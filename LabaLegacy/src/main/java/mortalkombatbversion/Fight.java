package mortalkombatbversion;

import javax.swing.JLabel;
import Characters.Action;
import Characters.Enemy;
import Characters.Human;
import Characters.Player;
import Characters.ShaoKahn;

/**
 * Класс, управляющий боевой системой игры.
 * Обрабатывает взаимодействие между игроком и противником,
 * включая атаки, защиту и специальные способности.
 * 
 * @author kateero
 * @version 1.0
 */
public class Fight {

    private Human player;
    private Enemy enemy;
    private int stunStatus = 0; // 0 - нет оглушения, 1 - игрок оглушен, 2 - враг оглушен
    private int playerWins = 0;
    private int currentLevel = 1;
    private JLabel logLabel;
    private BattleEndListener battleEndListener;

    /**
     * Создает новый экземпляр боя между игроком и противником.
     * 
     * @param player игрок (персонаж, управляемый пользователем)
     * @param enemy противник (управляемый компьютером)
     * @param logLabel метка для отображения игровых сообщений
     */
    public Fight(Human player, Enemy enemy, JLabel logLabel) {
        this.player = player;
        this.enemy = enemy;
        this.logLabel = logLabel;
    }

    /**
     * Обрабатывает ход игрока.
     * Проверяет статус оглушения, применяет выбранное действие
     * и проверяет условия победы/поражения.
     * 
     * @param playerAction действие, выбранное игроком
     */
    public void playerMove(Action playerAction) {
        // Ход игрока
        if (stunStatus == 1) {
            logLabel.setText(player.getName() + " оглушен и пропускает ход!");
            stunStatus = 0;
        } else {
            player.updateDebuff();
            Action enemyReaction = enemy.getNextAction();
            resolveActions(playerAction, enemyReaction, true);
        }

        if (enemy.getHealth() <= 0) {
            handleVictory();
        } else if (player.getHealth() <= 0) {
            handleDefeat();
        }
    }

    /**
     * Обрабатывает ход компьютера.
     * Применяет действие противника и обновляет состояние боя.
     * 
     * @param playerReaction действие, выбранное игроком
     */
    public void computerMove(Action playerReaction) {
        //Ход компьютера
        if (enemy.getHealth() > 0) {
            if (stunStatus == 2) {
                logLabel.setText(enemy.getName() + " оглушен и пропускает ход!");
                stunStatus = 0;
            } else {
                enemy.updateDebuff();
                Action enemyAction = enemy.getNextAction();
              
                if (enemy instanceof ShaoKahn) {
                    ShaoKahn boss = (ShaoKahn) enemy;
                    
                    if (enemyAction == Action.REGENERATE) {
                        if (playerReaction == Action.DEFEND) {
                            int regenAmount = boss.getRegenerationAmount();
                            boss.changeHealth(regenAmount);
                            logLabel.setText("Босс восстановил " + regenAmount + " здоровья!");
                            return;
                        } else if (playerReaction == Action.ATTACK) {
                            int damage = player.getDamage() * 2;
                            boss.changeHealth(-damage);
                            logLabel.setText("Босс получил двойной урон: " + damage + "!");
                            return;
                        }
                    }
                    
                    if (enemyAction == Action.ATTACK && playerReaction == Action.DEFEND && boss.shouldBreakBlock()) {
                        int damage = (int)(boss.getDamage() * 0.5);
                        player.changeHealth(-damage);
                        logLabel.setText("Босс пробил блок! Нанесено " + damage + " урона!");
                        return;
                    }
                }
                
                resolveActions(enemyAction, playerReaction, false);
            }
        }

        if (enemy.getHealth() <= 0) {
            handleVictory();
        } else if (player.getHealth() <= 0) {
            handleDefeat();
        }
    }

    /**
     * Разрешает взаимодействие между действиями игрока и противника.
     * 
     * @param initiatorAction действие первого участника
     * @param responderAction действие второго участника
     * @param isPlayerInitiator true если первое действие от игрока, false если от противника
     */
    private void resolveActions(Action initiatorAction, Action responderAction, boolean isPlayerInitiator) {
        Player initiator;
        Player responder;

        if (isPlayerInitiator) {
            initiator = player;
            responder = enemy;
        } else {
            initiator = enemy;
            responder = player;
        }

        switch (initiatorAction) {
            case ATTACK:
                if (responderAction == Action.DEFEND) {
                    // Атака + Защита = Контрудар вполсилы
                    int counterDamage = (int) (responder.getDamage() * 0.5);
                    initiator.changeHealth(-counterDamage);
                    logLabel.setText(responder.getName() + " контратаковал на " + counterDamage + " урона!");
                } else {
                    // Атака + Атака = Инициатор наносит урон
                    responder.changeHealth(-initiator.getDamage());
                    logLabel.setText(initiator.getName() + " атаковал на " + initiator.getDamage() + " урона!");
                }
                break;

            case DEFEND:
                if (responderAction == Action.DEFEND) {
                    // Защита + Защита = 50% шанс оглушения
                    if (Math.random() < 0.5) {
                        if (isPlayerInitiator) {
                            stunStatus = 2; // враг оглушен
                            logLabel.setText("Оба защищались! " + enemy.getName() + " оглушен!");
                        } else {
                            stunStatus = 1; // игрок оглушен
                            logLabel.setText("Оба защищались! " + player.getName() + " оглушен!");
                        }
                    }
                }
                break;

            case WEAKEN:
                initiator.applyWeaken(responder, responderAction);
                if (responderAction == Action.DEFEND && responder.isWeakened()) {
                    logLabel.setText(initiator.getName() + " ослабил " + responder.getName() + "!");
                } else if (responderAction == Action.ATTACK) {
                    logLabel.setText(responder.getName() + " сорвал ослабление!");
                } else {
                    logLabel.setText(initiator.getName() + " не может использовать ослабление!");
                }
                break;
        }
    }

    /**
     * Обрабатывает победу игрока.
     * Начисляет опыт, очки и вызывает соответствующий callback.
     */
    private void handleVictory() {
        playerWins++;
        int expGain = calculateExperience();
        
        if (enemy instanceof ShaoKahn) {
            expGain *= 2;
        }
        
        player.addExperience(expGain);
        int points = calculatePoints();
        
        if (enemy instanceof ShaoKahn) {
            points *= 2; 
        }
        
        player.addPoints(points);
        
        if (battleEndListener != null) {
            battleEndListener.onBattleEnd(true);
        }
        
        if (playerWins >= getWinsForLevel(currentLevel)) {
            currentLevel++;
            player.levelUp();
            logLabel.setText("Уровень повышен! Теперь уровень " + currentLevel);
        }
    }

    /**
     * Обрабатывает поражение игрока.
     * Вызывает соответствующий callback для завершения боя.
     */
    private void handleDefeat() {
        if (battleEndListener != null) {
            battleEndListener.onBattleEnd(false);
        }
    }

    private int calculateExperience() {
        return 10 + currentLevel * 5;
    }

    private int calculatePoints() {
        return (int) (player.getHealth() / (double) player.getMaxHealth() * 100);
    }

    private int getWinsForLevel(int level) {
        return switch (level) {
            case 1 -> 2;
            case 2 -> 4;
            case 3 -> 7;
            case 4 -> 9;
            case 5 -> 12;
            default -> 15;
        };
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getWinsForNextLevel() {
        return getWinsForLevel(currentLevel);
    }

    /**
     * Возвращает текущего игрока.
     * 
     * @return объект игрока
     */
    public Human getPlayer() {
        return player;
    }

    /**
     * Возвращает текущего противника.
     * 
     * @return объект противника
     */
    public Enemy getEnemy() {
        return enemy;
    }
    
    /**
     * Устанавливает слушателя для событий окончания боя.
     * 
     * @param listener объект, реализующий интерфейс BattleEndListener
     */
    public void setBattleEndListener(BattleEndListener listener) {
        this.battleEndListener = listener;
    }

    /**
     * Интерфейс для обработки событий окончания боя.
     */
    public interface BattleEndListener {
        /**
         * Вызывается при завершении боя.
         * 
         * @param playerWon true если победил игрок, false если победил противник
         */
        void onBattleEnd(boolean playerWon);
    }
}
