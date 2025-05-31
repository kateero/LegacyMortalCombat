package mortalkombatbversion;

import Characters.Enemy;
import Characters.EnemyFabric;
import Characters.EnemyType;
import Characters.Human;
import GUI.galaFrame;
import GUI.loseDialog;
import GUI.chooseImproveDialog;
import GUI.whoWinDialog;
import GUI.winGameDialog;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 * Основной класс, управляющий игровым процессом.
 * Отвечает за создание и управление локациями, противниками,
 * и общим состоянием игры.
 * 
 * @author kateero
 * @version 1.0
 */
public class Game {

    private int locationQuantity;
    private int currentLocation;
    private Human human;
    private EnemyFabric enemyFabric;
    private ArrayList<Enemy> currentEnemies;
    private Random random;
    private boolean gameOver;
    private galaFrame galaFrame;
    private int currentEnemyIndex;

    /**
     * Создает новую игру с указанным количеством локаций.
     * 
     * @param quantityLocation количество локаций в игре
     * @param galaFrame главное окно игры
     */
    public Game(int quantityLocation, galaFrame galaFrame) {
        this.locationQuantity = quantityLocation;
        this.human = new Human();
        this.enemyFabric = new EnemyFabric();
        this.random = new Random();
        this.gameOver = false;
        this.galaFrame = galaFrame;
        this.currentEnemies = new ArrayList<>();
        this.currentEnemyIndex = 0;
    }

    /**
     * Запускает игру, инициализируя начальное состояние
     * и переходя к первой локации.
     */
    public void startGame() {
        resetGameState();
        playNextLocation();
    }

    /**
     * Сбрасывает состояние игры к начальным значениям.
     */
    private void resetGameState() {
        currentLocation = 0;
        gameOver = false;
        currentEnemyIndex = 0;
        currentEnemies.clear();
        human = new Human();
    }

    /**
     * Инициализирует следующую локацию, создавая новых противников
     * и запуская следующий бой.
     */
    private void playNextLocation() {
        if (currentLocation >= locationQuantity || gameOver) {
            endGame();
            return;
        }

        int enemiesCount = 1 + random.nextInt(3) + human.getLevel();
        currentEnemies = generateEnemies(enemiesCount);
        currentEnemies.add(enemyFabric.createEnemy(EnemyType.BOSS, human.getLevel() + 1, human));
        currentEnemyIndex = 0;

        startNextFight();
    }

    /**
     * Начинает следующий бой с текущим противником.
     * Если все противники в локации побеждены, переходит к следующей локации.
     */
    private void startNextFight() {
        if (currentEnemyIndex >= currentEnemies.size()) {
            currentLocation++;
            if (currentLocation >= locationQuantity) {
                endGame();
                return;
            }
            human.levelUp();
            SwingUtilities.invokeLater(() -> {
                chooseImproveDialog improveDialog = new chooseImproveDialog(galaFrame, human);
                improveDialog.setVisible(true);
            });
            playNextLocation();
            return;
        }

        Enemy currentEnemy = currentEnemies.get(currentEnemyIndex);
        Fight fight = new Fight(human, currentEnemy, galaFrame.getLabelMoves());
        galaFrame.setFight(fight);
        galaFrame.initilaize();

        fight.setBattleEndListener(new Fight.BattleEndListener() {
            @Override
            public void onBattleEnd(boolean playerWon) {
                if (playerWon) {
                    currentEnemyIndex++;
                    SwingUtilities.invokeLater(() -> {
                        whoWinDialog winDialog = new whoWinDialog(galaFrame);
                        winDialog.setVisible(true);
                        if (currentEnemyIndex < currentEnemies.size()) {
                            startNextFight();
                        } else {
                            currentLocation++;
                            if (currentLocation >= locationQuantity) {
                                endGame();
                            } else {
                                human.levelUp();
                                chooseImproveDialog improveDialog = new chooseImproveDialog(galaFrame, human);
                                improveDialog.setVisible(true);
                                playNextLocation();
                            }
                        }
                    });
                } else {
                    gameOver = true;
                    SwingUtilities.invokeLater(() -> {
                        loseDialog dialog = new loseDialog(galaFrame);
                        galaFrame.setVisible(false);
                        dialog.setVisible(true);
                        resetGameState(); 
                    });
                }
            }
        });
    }

    /**
     * Генерирует список противников для текущей локации.
     * 
     * @param count количество противников для генерации
     * @return список сгенерированных противников
     */
    private ArrayList<Enemy> generateEnemies(int count) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            EnemyType type = EnemyType.values()[random.nextInt(EnemyType.values().length - 1)];
            int enemyLevel = Math.max(1, human.getLevel() + 1);
            enemies.add(enemyFabric.createEnemy(type, enemyLevel, human));
        }
        return enemies;
    }

    /**
     * Завершает игру, показывая соответствующий диалог
     * 
     */
    private void endGame() {
        if (!gameOver) {
            SwingUtilities.invokeLater(() -> {
                galaFrame.setVisible(false);
                winGameDialog dialog = new winGameDialog(galaFrame, human.getPoints());
                dialog.setVisible(true);
            });
        }
    }
}
