package mortalkombatbversion.Characters;

public class SubZero extends Enemy {

    public SubZero(int level) {
        super(level, 60, 16, EnemyType.MAGE);
    }

    @Override
    public String getName() {
        return "Sub-Zero";
    }
}
