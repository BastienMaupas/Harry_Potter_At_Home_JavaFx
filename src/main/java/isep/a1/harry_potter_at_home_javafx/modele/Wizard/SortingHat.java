package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

public class SortingHat {

    /*public House assignHouse() {
        int housenum = (int) (Math.random() * 4);
        if (housenum == 0 ){
            return House.Gryffindor;
        }
        if (housenum == 1 ){
            return House.Slytherin;
        }
        if (housenum == 2 ){
            return House.Hufflepuff;
        }
        else{
            return House.Ravenclaw;
        }
    }*/

    public House assignHouse() {
        GameMethod myGamemethod= new GameMethod();
        System.out.println("Now we will proceed to your house assignment");
        System.out.println("Try to answer the following question as honestly as you can");
        System.out.println("Which character trait do you think describes you the most:");
        System.out.println("(1) Determination\n(2) Bravery\n(3) Loyalty\n(4) Wisdom");
        int choose = myGamemethod.readInt("->", 4);
        System.out.println("Congratulations! You have been assigned to the "+myGamemethod.setupHouse().get(choose-1).getName()+" house");
        return myGamemethod.setupHouse().get(choose-1);
    }

}
