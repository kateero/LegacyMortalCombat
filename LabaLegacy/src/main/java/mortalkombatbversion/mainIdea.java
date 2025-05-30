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
import java.awt.Window;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mortalkombatbversion.Fight;
import mortalkombatbversion.Fight.BattleEndListener;


public class mainIdea {

    private int locationQuantity;
    private int currentLocation;
    private Human human;
    private EnemyFabric enemyFabric;
    private ArrayList<Enemy> currentEnemies;
    private Random random;
    private boolean gameOver;
    private galaFrame galaFrame;
    private int currentEnemyIndex;

    public mainIdea(int quantityLocation, galaFrame galaFrame) {
        this.locationQuantity = quantityLocation;
        this.human = new Human();
        this.enemyFabric = new EnemyFabric();
        this.random = new Random();
        this.gameOver = false;
        this.galaFrame = galaFrame;
        this.currentEnemies = new ArrayList<>();
        this.currentEnemyIndex = 0;
    }

    public void startGame() {
        resetGameState();
        playNextLocation();
    }

    private void resetGameState() {
        currentLocation = 0;
        gameOver = false;
        currentEnemyIndex = 0;
        currentEnemies.clear();
        human = new Human(); // Создаем нового игрока при новой игре
    }

    private void playNextLocation() {
        if (currentLocation >= locationQuantity || gameOver) {
            endGame();
            return;
        }

        int enemiesCount = 1 + random.nextInt(3) + human.getLevel();
        currentEnemies = generateEnemies(enemiesCount);
        currentEnemyIndex = 0;

        startNextFight();
    }

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
                        resetGameState(); // Сбрасываем состояние игры после поражения
                    });
                }
            }
        });
    }

    private ArrayList<Enemy> generateEnemies(int count) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            EnemyType type = EnemyType.values()[random.nextInt(EnemyType.values().length)];
            int enemyLevel = Math.max(1, human.getLevel() + 1);
            enemies.add(enemyFabric.createEnemy(type, enemyLevel));
        }
        //        Добавить босса в конце локации
        //        enemies.add(createBoss());
        return enemies;
    }

    private void endGame() {
        if (!gameOver) {
            // Победа в игре
            SwingUtilities.invokeLater(() -> {
                galaFrame.setVisible(false);
                winGameDialog dialog = new winGameDialog(galaFrame);
                dialog.setVisible(true);
            });
        }
    }

}
