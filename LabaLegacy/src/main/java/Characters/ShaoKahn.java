package Characters;

import java.util.Random;

public class ShaoKahn extends Enemy {
    private int totalDamageTaken = 0;
    private Random random = new Random();

    public ShaoKahn(int level, Human player) {
        super(level, calculateHealth(player), 25, EnemyType.TANK, "/ShaoKahn.jpg");
    }

    private static int calculateHealth(Human player) {
        return (int)(player.getMaxHealth() * 0.5);
    }

    @Override
    public String getName() {
        return "Shao Kahn";
    }

    @Override
    public Action getNextAction() {
        if (random.nextDouble() < 0.2 && totalDamageTaken > 0) {
            return Action.REGENERATE;
        }

        double rand = random.nextDouble();
        if (rand < 0.6) {
            return Action.ATTACK;
        } else if (rand < 0.8) {
            return Action.DEFEND;
        } else {
            return Action.WEAKEN;
        }
    }

    @Override
    public void changeHealth(int change) {
        if (change < 0) {
            totalDamageTaken -= change;
        }
        super.changeHealth(change);
    }

    public boolean shouldBreakBlock() {
        return random.nextDouble() < 0.15;
    }

    public int getRegenerationAmount() {
        return totalDamageTaken / 2;
    }

}
