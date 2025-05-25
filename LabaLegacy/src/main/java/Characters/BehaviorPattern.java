package Characters;

import java.util.List;
import java.util.Random;

public enum BehaviorPattern {
    
    ATTACK_DEFEND(List.of(Action.ATTACK, Action.DEFEND)),
    ATTACK_ATTACK_DEFEND(List.of(Action.ATTACK, Action.ATTACK, Action.DEFEND)),
    DEFEND_ATTACK_DEFEND(List.of(Action.DEFEND, Action.ATTACK, Action.DEFEND)),
    FOUR_ATTACKS(List.of(Action.ATTACK, Action.ATTACK, Action.ATTACK, Action.ATTACK)),
    MAGE_ATTACKS(List.of(Action.ATTACK, Action.WEAKEN, Action.ATTACK));

    private final List<Action> actions;

    BehaviorPattern(List<Action> actions) {
        this.actions = actions;
    }

    public List<Action> getActions() {
        return actions;
    }
    
    public static BehaviorPattern getRandomAttackDefend() {
        Random rand = new Random();
        return rand.nextBoolean() ? ATTACK_DEFEND : ATTACK_ATTACK_DEFEND;
    }
}
