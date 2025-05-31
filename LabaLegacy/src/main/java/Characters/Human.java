package Characters;

/**
 * Класс, представляющий игрового персонажа, управляемого пользователем.
 * Расширяет базовый класс {@link Player} и добавляет систему опыта,
 * очков и уровней.
 * 
 * @author kateero
 * @version 1.0
 */
public class Human extends Player{
    
    private int points;
    private int experience;
    private int win;
    private int nextexperience;

    /**
     * Создает нового персонажа игрока с начальными характеристиками:
     * - Уровень: 0
     * - Здоровье: 80
     * - Урон: 16
     * - Изображение: Kitana.jpg
     */
    public Human() {
        super(0, 80, 16, "/Kitana.jpg");
        this.points = 0;
        this.experience = 0;
        this.nextexperience = 40;
        this.win = 0;
    }

    /**
     * @return текущее количество очков игрока
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return текущее количество опыта
     */
    public int getExperience() {
        return experience;
    }

    /**
     * @return количество опыта, необходимое для следующего уровня
     */
    public int getNextExperience() {
        return nextexperience;
    }

    /**
     * @return количество побед
     */
    public int getWin() {
        return win;
    }

    /**
     * Добавляет очки к текущему счету игрока.
     * 
     * @param points количество добавляемых очков
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Проверяет, достаточно ли опыта для повышения уровня.
     * 
     * @return true если можно повысить уровень, false в противном случае
     */
    public boolean canLevelUp() {
        return experience >= nextexperience;
    }

    /**
     * Добавляет опыт и автоматически повышает уровень,
     * если достигнуто необходимое количество опыта.
     * 
     * @param exp количество добавляемого опыта
     */
    public void addExperience(int exp) {
        this.experience += exp;
        if (canLevelUp()) levelUp();
    }

    /**
     * Устанавливает новое значение опыта, необходимого для следующего уровня.
     * 
     * @param e новое значение необходимого опыта
     */
    public void setNextExperience(int e) {
        this.nextexperience = e;
    }

    /**
     * Увеличивает счетчик побед на 1.
     */
    public void addWin() {
        this.win++;
    }

    @Override
    public String getName() {
        return "You";
    }
    
    /**
     * Повышает уровень персонажа, если достигнуто необходимое количество опыта.
     * При повышении уровня:
     * - Увеличивается уровень
     * - Сбрасывается текущий опыт
     * - Увеличивается требование опыта для следующего уровня
     */
    public void levelUp() {
        if (canLevelUp()) {
            addLevel();
            experience -= nextexperience;
            nextexperience = (int)(nextexperience * 1.5);
            // Характеристики будут улучшаться через диалог
        }
    }
}