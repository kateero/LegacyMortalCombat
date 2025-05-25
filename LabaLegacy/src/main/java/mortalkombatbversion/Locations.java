package mortalkombatbversion;

public class Locations {
    private String[] locations = {"Битва в лесу", "Битва на горе", 
                    "Битва в подземелье", "Битва на арене", "Битва в храме", 
                    "Битва в пустыне", "Битва на кладбище", "Битва в портале", 
                    "Битва на крыше", "Битва в лабиринте"};
    
    public String getLocation(int number){
        return locations[number % 10];
    }
}
