
package mortalkombatbversion;

import Characters.Enemy;
import Characters.EnemyFabric;
import Characters.EnemyType;
import Characters.Human;
import GUI.galaFrame;
import GUI.loseDialog;
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
        currentLocation = 0;
        gameOver = false;
        playNextLocation();
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
            SwingUtilities.invokeLater(() -> {
                if (playerWon) {
                    currentEnemyIndex++;
                    if (currentEnemyIndex < currentEnemies.size()) {
                        // Немедленный переход к следующему врачу
                        startNextFight();
                    } else {
                        // Все враги побеждены, переход к новой локации
                        currentLocation++;
                        playNextLocation();
                    }
                } else {
                    gameOver = true;
                    Window parent = SwingUtilities.getWindowAncestor(null);
                    loseDialog dialog = new loseDialog((JFrame) parent);
                    dialog.setVisible(true);
                }
            });
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
        if (gameOver) {

        } else {
            // galaFrame.showVictoryDialog("Поздравляем! Вы прошли все локации!");
        }
    }

}
