package Characters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Базовый класс для всех игровых персонажей.
 * Содержит основные характеристики и механики персонажа,
 * такие как здоровье, урон, уровень и эффекты ослабления.
 * 
 * @author kateero
 * @version 1.0
 */
public class Player {

    private int level;
    private int health;
    private int maxhealth;
    private int baseDamage;
    private Debuff activeDebuff;
    private double damageBonus = 1.0;
    private boolean isWeakened = false;
    private BufferedImage image;

    /**
     * Создает нового персонажа с указанными характеристиками.
     * 
     * @param level начальный уровень персонажа
     * @param health начальное количество здоровья
     * @param damage базовый урон
     * @param imagePath путь к изображению персонажа
     */
    public Player(int level, int health, int damage, String imagePath) {
        this.level = level;
        this.health = health;
        this.maxhealth = health;
        this.baseDamage = damage;

        InputStream imageStream = Player.class.getResourceAsStream(imagePath);
        try {
            this.image = ImageIO.read(imageStream);
        } catch (IOException ex){
            System.err.println("Файл не найден");
        }
    }

    /**
     * Повышает уровень персонажа на 1.
     */
    public void addLevel() {
        this.level++;
    }

    /**
     * Изменяет текущее здоровье персонажа.
     * Здоровье не может превысить максимальное значение
     * и не может опуститься ниже 0.
     * 
     * @param addHealth величина изменения здоровья (может быть отрицательной)
     */
    public void changeHealth(int addHealth) {
        this.health = Math.min(this.health + addHealth, this.maxhealth);
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Устанавливает новое значение здоровья.
     * 
     * @param newHealth новое значение здоровья
     */
    public void setNewHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * Увеличивает базовый урон персонажа.
     * 
     * @param addDamage величина увеличения урона
     */
    public void addDamage(int addDamage) {
        this.baseDamage += addDamage;
    }

    /**
     * Увеличивает максимальное здоровье персонажа.
     * 
     * @param maxhealth величина увеличения максимального здоровья
     */
    public void addMaxHealth(int maxhealth) {
        this.maxhealth += maxhealth;
    }

    /**
     * Устанавливает множитель урона.
     * Используется для временных эффектов усиления/ослабления.
     * 
     * @param damageBonus множитель урона (1.0 - нормальный урон)
     */
    public void setDamageBonus(double damageBonus) {
        this.damageBonus = damageBonus;
    }

    /**
     * @return текущий уровень персонажа
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return текущее здоровье персонажа
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return текущий урон персонажа с учетом множителя
     */
    public int getDamage() {
        return (int) (baseDamage * damageBonus);
    }

    /**
     * @return максимальное здоровье персонажа
     */
    public int getMaxHealth() {
        return maxhealth;
    }

    /**
     * @return имя персонажа
     */
    public String getName() {
        return "";
    }

    /**
     * @return изображение персонажа
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @return true если персонаж ослаблен, false в противном случае
     */
    public boolean isWeakened() {
        return isWeakened;
    }

    /**
     * Применяет эффект ослабления к цели.
     * Шанс успешного применения зависит от действия цели.
     * 
     * @param target цель для ослабления
     * @param targetAction текущее действие цели
     */
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

    /**
     * Применяет эффект ослабления к персонажу.
     * 
     * @param debuff объект эффекта ослабления
     */
    public void receiveDebuff(Debuff debuff) {
        this.activeDebuff = debuff;
        this.isWeakened = true;
    }

    /**
     * Обновляет состояние эффекта ослабления.
     * Уменьшает длительность и удаляет истекшие эффекты.
     */
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
