package isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wand;

public enum Core {
    Phoenix_Feather, Dragon_Heartstring;

    public static Core assignCore(){
        int Corenum = (int) (Math.random() * 4);
        if (Corenum == 0) {
            return Core.Phoenix_Feather;
        }
        else {
            return Core.Dragon_Heartstring;
        }
    }
}