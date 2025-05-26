package Characters;

public class Human extends Player{
    
    private int points;
    private int experience;
    private int win;
    private int nextexperience;

    public Human() {
        super(0, 80, 16);
        this.points = 0;
        this.experience = 0;
        this.nextexperience = 40;
        this.win = 0;
    }

    public int getPoints() {
        return points;
    }

    public int getExperience() {
        return experience;
    }

    public int getNextExperience() {
        return nextexperience;
    }

    public int getWin() {
        return win;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public boolean canLevelUp() {
        return experience >= nextexperience;
    }

    public void addExperience(int exp) {
        this.experience += exp;
        if (canLevelUp()) levelUp();
    }


    public void setNextExperience(int e) {
        this.nextexperience = e;
    }

    public void addWin() {
        this.win++;
    }

    @Override
    public String getName() {
        return "You";
    }
    
    public void levelUp() {
        if (canLevelUp()) {
            addLevel();
            experience -= nextexperience;
            nextexperience = (int)(nextexperience * 1.5);
        }
    }

}