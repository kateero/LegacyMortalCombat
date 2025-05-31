package Characters;

public class LiuKang extends Enemy {

    public LiuKang(int level) {
        super(level, 70, 20, EnemyType.FIGHTER, "/LiuKang.jpg");
    }

    @Override
    public String getName() {
        return "Liu Kang";
    }
}
