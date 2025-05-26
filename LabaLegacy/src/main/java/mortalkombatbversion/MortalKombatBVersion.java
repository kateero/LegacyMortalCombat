package mortalkombatbversion;

import GUI.galaFrame;

public class MortalKombatBVersion {

    public static void main(String[] args) {
        galaFrame gf = new galaFrame();
        mainIdea m = new mainIdea(1, gf);
        m.startGame();
        gf.setVisible(true);
    }
}
