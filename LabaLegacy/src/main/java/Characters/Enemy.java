package Characters;

public class Enemy extends Player {

    private EnemyType type;
    private BehaviorPattern currentPattern;
    private int patternStep = 0;

    public Enemy(int level, int health, int damage, EnemyType type, String filePath) {
        super(level,
                (int) (health * (1 + 0.3 * (level - 1))),
                (int) (damage * (1 + 0.2 * (level - 1))), filePath);
        this.type = type;
        this.currentPattern = this.generateBehaviorPattern();
    }

    private BehaviorPattern generateBehaviorPattern() {
        double rand = Math.random() * 100;
        switch (this.type) {
            case TANK: return getTankPattern(rand);
            case MAGE: return getMagePattern(rand);
            case FIGHTER: return getFighterPattern(rand);
            case SOLDIER: return getSoldierPattern(rand);
            default: return BehaviorPattern.getRandomAttackDefend();
        }
    }

    public Action getNextAction() {
        Action action = currentPattern.getActions().get(patternStep);
        patternStep++;

        if (patternStep >= currentPattern.getActions().size()) {
            currentPattern = generateBehaviorPattern();
            patternStep = 0;
        }
        return action;
    }

    private BehaviorPattern getTankPattern(double rand) {
        if (rand < 30) {
            return BehaviorPattern.getRandomAttackDefend();
        } else if (rand < 90) {
            return BehaviorPattern.DEFEND_ATTACK_DEFEND;
        } else {
            return BehaviorPattern.FOUR_ATTACKS;
        }
    }

    private BehaviorPattern getMagePattern(double rand) {
        if (rand < 30) {
            return BehaviorPattern.getRandomAttackDefend();
        } else if (rand < 70) {
            return BehaviorPattern.MAGE_ATTACKS;
        } else {
            return BehaviorPattern.FOUR_ATTACKS;
        }
    }

    private BehaviorPattern getFighterPattern(double rand) {
        if (rand < 25) {
            return BehaviorPattern.getRandomAttackDefend();
        } else if (rand < 35) {
            return BehaviorPattern.DEFEND_ATTACK_DEFEND;
        } else {
            return BehaviorPattern.FOUR_ATTACKS;
        }
    }

    private BehaviorPattern getSoldierPattern(double rand) {
        if (rand < 50) {
            return BehaviorPattern.getRandomAttackDefend();
        } else {
            return BehaviorPattern.DEFEND_ATTACK_DEFEND;
        }
    }

    public void setWeakened(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
