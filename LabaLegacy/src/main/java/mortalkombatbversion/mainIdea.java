package mortalkombatbversion;

import Characters.Enemy;
import Characters.EnemyFabric;
import Characters.EnemyType;
import Characters.Human;
import GUI.galaFrame;
import java.util.ArrayList;
import java.util.Random;

public class mainIdea {

    private int locationQuantity;
    private int currentLocation;
    private Human human;
    private EnemyFabric enemyFabric;
    private Random random;
    private boolean gameOver;
    private galaFrame galaFrame;

    public mainIdea(int quantityLocation, galaFrame galaFrame) {
        this.locationQuantity = quantityLocation;
        this.human = new Human();
        this.enemyFabric = new EnemyFabric();
        this.random = new Random();
        this.gameOver = false;
        this.galaFrame = galaFrame;
    }

    public void startGame() {
        galaFrame.setHuman(human);
        while (!gameOver && currentLocation < locationQuantity) {
            playLocation();
            currentLocation++;
        }

        if (!gameOver) {
            System.out.println("Поздравляем! Вы прошли все локации!");
        }
    }

    private void playLocation() {

        int enemiesCount = 1 + random.nextInt(3) + human.getLevel();
        ArrayList<Enemy> enemies = generateEnemies(enemiesCount);

//        Добавить босса в конце локации
//        enemies.add(createBoss());

        for (Enemy enemy : enemies) {
            galaFrame.setEnemy(enemy);
            Fight fight = new Fight(human, enemy, galaFrame.getLabelMoves());
            galaFrame.setFight(fight);
            galaFrame.initilaize();
        }

        System.out.println("Локация пройдена!");
    }

    private ArrayList<Enemy> generateEnemies(int count) {
        ArrayList<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            EnemyType type = EnemyType.values()[random.nextInt(EnemyType.values().length)];
            int enemyLevel = Math.max(1, human.getLevel() + 1);
            enemies.add(enemyFabric.createEnemy(type, enemyLevel));
        }
        return enemies;
    }

}
