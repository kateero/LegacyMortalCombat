package Characters;

public class EnemyFabric {
    public Enemy createEnemy(EnemyType type, int level) {
        switch (type) {
            case TANK:    return new Baraka(level);
            case MAGE:    return new SubZero(level);
            case FIGHTER: return new LiuKang(level);
            case SOLDIER: return new SonyaBlade(level);
            default: throw new IllegalArgumentException("Неизвестный тип врага");
        }
    }
}