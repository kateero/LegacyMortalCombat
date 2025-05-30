package Characters;

public class SonyaBlade extends Enemy {

    public SonyaBlade(int level) {
        super(level, 80, 25, EnemyType.SOLDIER);
    }

    @Override
    public String getName() {
        return "Sonya Blade";
    }
}
