package mortalkombatbversion.Characters;

import mortalkombatbversion.Characters.EnemyFabricInterface;
import mortalkombatbversion.Player;

public class SubZeroFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new SubZero(1, 60, 16, 1);
        return enemy;
    }

}
