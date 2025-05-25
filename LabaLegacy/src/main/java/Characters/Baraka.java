package Characters;

public class Baraka extends Enemy {

    public Baraka(int level) {
        super(level, 100, 12, EnemyType.TANK);
    }

    @Override
    public String getName() {
        return "Baraka";
    }

}
