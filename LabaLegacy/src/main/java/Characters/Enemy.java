package Characters;

public class Enemy extends Player {

    private EnemyType type;
    private BehaviorPattern currentPattern;
    private int patternStep = 0;

    public Enemy(int level, int health, int damage, EnemyType type) {
        super(level,
                (int) (health * (1 + 0.3 * (level - 1))),
                (int) (damage * (1 + 0.2 * (level - 1))));
        this.type = type;
        this.currentPattern = this.generateBehaviorPattern();
    }

    private BehaviorPattern generateBehaviorPattern() {
        double rand = Math.random() * 100;

        switch (this.type) {

            case TANK:
                if (rand < 30) {
                    return BehaviorPattern.getRandomAttackDefend();
                } else if (rand < 90) {
                    return BehaviorPattern.DEFEND_ATTACK_DEFEND;
                } else {
                    return BehaviorPattern.FOUR_ATTACKS;
                }

            case MAGE:
                if (rand < 30) {
                    return BehaviorPattern.getRandomAttackDefend();
                } else if (rand < 70) {
                    return BehaviorPattern.MAGE_ATTACKS;
                } else {
                    return BehaviorPattern.FOUR_ATTACKS;
                }

            case FIGHTER:
                if (rand < 25) {
                    return BehaviorPattern.getRandomAttackDefend();
                } else if (rand < 35) {
                    return BehaviorPattern.DEFEND_ATTACK_DEFEND;
                } else {
                    return BehaviorPattern.FOUR_ATTACKS;
                }

            case SOLDIER:
                return (rand < 50) ? BehaviorPattern.getRandomAttackDefend() : BehaviorPattern.DEFEND_ATTACK_DEFEND;

            default:
                return BehaviorPattern.getRandomAttackDefend();
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
}
