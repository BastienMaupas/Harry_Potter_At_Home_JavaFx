package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

public class Story {

    GameMethod mygameMethod= new GameMethod();

    public void level1Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("THE PHILOSOPHER'S STONE");
        mygameMethod.anythingToContinue();
        mygameMethod.printSeperator(30);
        System.out.println("You were just going to the toilets but a troll has just left the dungeon!");
        System.out.println("You are now in front of him but you are not strong enough to beat him in a fair fight...");
        System.out.println("Try to find a trick with the spells you have learned to beat him!");
    }

    public void level1Outro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("Nice one! You beat him! You now can go back to your common room to rest a bit and finish your year quietly.");
        mygameMethod.anythingToContinue();
    }

    public void level2Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("THE CHAMBER OF SECRETS");
        mygameMethod.anythingToContinue();
        mygameMethod.printSeperator(30);
        System.out.println("Your year was going well until you heard about the Chamber of Secrets...");
        System.out.println("You went therefore there but you now face the terrible basilisk and he seems so strong, not sure you can beat him in a fair fight.");
        System.out.println("You also find a diary next to him. Maybe you could try to find something to destroy it.");
        mygameMethod.anythingToContinue();
    }

    public void level2Outro(){
        mygameMethod.printSeperator(30);
        System.out.println("You won! You can now go rest");
    }

    public void level3Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("THE PRISONER OF AZKABAN");
        mygameMethod.anythingToContinue();
        mygameMethod.printSeperator(30);
        System.out.println("This year was a bit particular since dementors have been running around Hogwarts the whole year.");
        System.out.println("You are now face to face to a horde of them and will try to use your new spell: Wingardium Leviosa.");
        mygameMethod.anythingToContinue();
    }

    public void level3Outro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("You won it! ");
    }

    public void level4Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("You were participating to the last test of the Goblet of fire tournament");
        System.out.println("You thought you had won it but the trophy sent you on graveyard with Voldemort and Peter Petigrow");
        System.out.println("You will have to make the best you can to reach the trophy again to go back to Hogwarts dodging your opponents terrifying spells");
        mygameMethod.anythingToContinue();
    }

    public void level4Outro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("You have succeeded to push back Voldemort and are back at Hogwarts");
        System.out.println("However, you seem destined to fight him again...");
    }

    public void level5Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("Your fifth year is coming to its end but you still have your exams to pass");
        System.out.println("However, to succeed this level, you will have to wait for the fireworks your friends are making to be used");
        mygameMethod.anythingToContinue();
    }

    public void level5Outro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("The fireworks are used!!! The year is over!");
    }

    public void level6Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("The deatheaters are attacking Hogwarts!");
        System.out.println("Get ready to defend the school");
        mygameMethod.anythingToContinue();
    }

    public void level6Outro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("You have succeeded to defend Hogwarts!");
        System.out.println("One more year and you will be graduate!");
    }

    public void level7Intro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("Your last year has come to its end...");
        System.out.println("However, your last challenge is to defend Hogwarts against 2 of the worst wizards of the history: Voldemort and Belatrix Lestrange");
        mygameMethod.anythingToContinue();
    }

    public void level7Outro(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("The fight of your destiny is finally over...");
        System.out.println("Voldemort is beaten, you have won");
        System.out.println("You are now going to be graduate in Hogwarts");
        mygameMethod.anythingToContinue();
    }

    public void level7Introbis(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("Your last year has come to its end...");
        System.out.println("However, since you have joined deathEaters ranks, you will betray all your friends at Hogwarts and attack the castle. You will fight Harry Potter and Albus Dumbledore");
        mygameMethod.anythingToContinue();
    }

    public void level7Outrobis(){
        mygameMethod.clearConsole();
        mygameMethod.printSeperator(30);
        System.out.println("The fight of your destiny is finally over...");
        System.out.println("You have destroyed Hogwarts");
        mygameMethod.anythingToContinue();
    }

}
