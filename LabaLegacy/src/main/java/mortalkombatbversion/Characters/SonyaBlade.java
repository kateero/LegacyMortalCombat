package mortalkombatbversion.Characters;

public class SonyaBlade extends Enemy {

    public SonyaBlade(int level) {
        super(level, 80, 60, EnemyType.SOLDIER);
    }

    @Override
    public String getName() {
        return "Sonya Blade";
    }
}
