package mortalkombatbversion.Characters;

public class EnemyFabric {

    private EnemyFabric() {}

    public static Enemy createBaraka(int level) {
        return new Baraka(level);
    }

    public static Enemy createShaoKahn(int level) {
        return new ShaoKahn(level);
    }
    
    public static Enemy createSonyaBlade(int level) {
        return new SonyaBlade(level);
    }
    
    public static Enemy createSubZero(int level) {
        return new SubZero(level);
    }
    
    public static Enemy createLiuKang(int level) {
        return new LiuKang(level);
    }
}
