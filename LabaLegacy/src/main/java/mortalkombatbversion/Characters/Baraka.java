package mortalkombatbversion.Characters;

import mortalkombatbversion.Player;

public class Baraka extends Player{
    
    public Baraka(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
    }
    
    @Override
    public String getName(){
        return "Baraka";
    }
    
}
