package mortalkombatbversion.Characters;

public class Debuff {

    private int remainingTurns;

    public Debuff(int playerLevel) {
        this.remainingTurns = playerLevel;
    }

    public boolean isActive() {
        return remainingTurns > 0;
    }

    public void decreaseTurns() {
        if (remainingTurns > 0) {
            remainingTurns--;
        }
    }
}
