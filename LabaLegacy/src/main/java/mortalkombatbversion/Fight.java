package mortalkombatbversion;

import javax.swing.JLabel;
import Characters.Action;
import Characters.Enemy;
import Characters.Human;
import Characters.Player;

public class Fight {

    private Human player;
    private Enemy enemy;
    private int stunStatus = 0; // 0 - нет оглушения, 1 - игрок оглушен, 2 - враг оглушен
    private int playerWins = 0;
    private int currentLevel = 1;
    private JLabel logLabel;
    private BattleEndListener battleEndListener;

    public Fight(Human player, Enemy enemy, JLabel logLabel) {
        this.player = player;
        this.enemy = enemy;
        this.logLabel = logLabel;
    }

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

    public void computerMove(Action playerReaction) {
        //Ход компьютера
        if (enemy.getHealth() > 0) {
            if (stunStatus == 2) {
                logLabel.setText(enemy.getName() + " оглушен и пропускает ход!");
                stunStatus = 0;
            } else {
                enemy.updateDebuff();
                Action enemyAction = enemy.getNextAction();
                resolveActions(enemyAction, playerReaction, false);
            }
        }

        if (enemy.getHealth() <= 0) {
            handleVictory();
        } else if (player.getHealth() <= 0) {
            handleDefeat();
        }
    }

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

    private void handleVictory() {
        playerWins++;
        int expGain = calculateExperience();
        player.addExperience(expGain);
        player.addPoints(calculatePoints());
        
        if (battleEndListener != null) {
            battleEndListener.onBattleEnd(true);
        }
        
        if (playerWins >= getWinsForLevel(currentLevel)) {
            currentLevel++;
            player.levelUp();
            logLabel.setText("Уровень повышен! Теперь уровень " + currentLevel);
        }
    }

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
            case 1 ->
                2;
            case 2 ->
                4;
            case 3 ->
                7;
            case 4 ->
                9;
            case 5 ->
                12;
            default ->
                15;
        };
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getWinsForNextLevel() {
        return getWinsForLevel(currentLevel);
    }

    public Human getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
    
    public interface BattleEndListener {
        void onBattleEnd(boolean playerWon);
    }

    public void setBattleEndListener(BattleEndListener listener) {
        this.battleEndListener = listener;
    }

}
