package mortalkombatbversion.Characters;

public class Player {

    private int level;
    private int health;
    private int maxhealth;
    private int damage;

    public Player(int level, int health, int  damage) {
        this.level = level;
        this.health = health;
        this.maxhealth = health;
        this.damage = damage;
    }

    public void setLevel() {
        this.level++;
    }

    public void setHealth(int addHealth) {
        this.health += addHealth;
    }

    public void setNewHealth(int newHealth) {
        this.health = newHealth;
    }

    public void setDamage(int addDamage) {
        this.damage += addDamage;
    }

    public void setMaxHealth(int maxhealth) {
        this.maxhealth += maxhealth;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMaxHealth() {
        return this.maxhealth;
    }

    public String getName() {
        return "";
    }

}
