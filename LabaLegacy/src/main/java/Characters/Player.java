package Characters;

public class Player {

    private int level;
    private int health;
    private int maxhealth;
    private int baseDamage;
    private Debuff activeDebuff;
    private double damageBonus = 1.0;
    private boolean isWeakened = false;

    public Player(int level, int health, int damage) {
        this.level = level;
        this.health = health;
        this.maxhealth = health;
        this.baseDamage = damage;
    }

    public void addLevel() {
        this.level++;
    }

    public void changeHealth(int addHealth) {
        this.health = Math.min(this.health + addHealth, this.maxhealth);
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void setNewHealth(int newHealth) {
        this.health = newHealth;
    }

    public void addDamage(int addDamage) {
        this.baseDamage += addDamage;
    }

    public void addMaxHealth(int maxhealth) {
        this.maxhealth += maxhealth;
    }

    public void setDamageBonus(double damageBonus) {
        this.damageBonus = damageBonus;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return (int) (baseDamage * damageBonus);
    }

    public int getMaxHealth() {
        return maxhealth;
    }

    public String getName() {
        return "";
    }

    public boolean isWeakened() {
        return isWeakened;
    }

    public void applyWeaken(Player target, Action targetAction) {
        if (targetAction == Action.DEFEND && Math.random() < 0.75) {
            // Успешное ослабление (75% при защите)
            target.receiveDebuff(new Debuff(this.level));
            target.setDamageBonus(0.5);
            this.receiveDebuff(new Debuff(1));
            this.setDamageBonus(1.25);
        } else if (targetAction == Action.ATTACK && target.activeDebuff != null) {
            // Срыв ослабления (при атаке)
            target.activeDebuff = null;
            this.receiveDebuff(new Debuff(1));
            this.setDamageBonus(1.25);
        }
    }

    public void receiveDebuff(Debuff debuff) {
        this.activeDebuff = debuff;
        this.isWeakened = true;
    }

    public void updateDebuff() {
        if (activeDebuff != null) {
            activeDebuff.decreaseTurns();
            if (!activeDebuff.isActive()) {
                activeDebuff = null;
                isWeakened = false;
                damageBonus = 1.0;
            }
        }
    }
}
