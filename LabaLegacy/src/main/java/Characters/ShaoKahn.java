package Characters;

public class ShaoKahn extends Enemy {

    //надо сделать боссом
    public ShaoKahn(int level) {
        super(level, 100, 30, EnemyType.MAGE);
    }

    @Override
    public String getName() {
        return "Shao Kahn";
    }
}
/*
 if(i==0){
            enemy = new ShaoKahn(3, 100, 30, 1);
        }
        else{
           enemy = new ShaoKahn(3, 145, 44, 1); 
        }
*/
