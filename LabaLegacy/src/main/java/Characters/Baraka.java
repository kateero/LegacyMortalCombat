package Characters;

public class Baraka extends Enemy {

    public Baraka(int level) {
        super(level, 90, 12, EnemyType.TANK, "/Baraka.jpg");
    }

    @Override
    public String getName() {
        return "Baraka";
    }

}
