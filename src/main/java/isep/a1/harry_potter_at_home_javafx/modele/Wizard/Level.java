package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

import static isep.a1.harry_potter_at_home_javafx.modele.Wizard.GameMethod.wizard;

public class Level {

    GameMethod mygameMethod= new GameMethod();

    Story mystory = new Story();

    public void level1(){
        /* Level 1 */

        mygameMethod.gameLoop();
        mystory.level1Intro();
        Enemy troll;
        troll = new Enemy("Troll", 100, 40, 200);
        mygameMethod.anythingToContinue();
        System.out.println("You are getting ready to fight the "+troll.getName());
        mygameMethod.anythingToContinue();
        mygameMethod.battle1(troll);
        mystory.level1Outro();
        mygameMethod.healWizard(wizard);
        mygameMethod.chooseUpgrade(wizard);
    }

    public void level2(){
        /* Level 2 */

        mygameMethod.addPotion(mygameMethod.setupPotions().get(1));
        mygameMethod.place = 1;
        mygameMethod.gameLoop();
        mygameMethod.learnSpell(mygameMethod.setupSpells().get(3));
        mygameMethod.anythingToContinue();
        mystory.level2Intro();
        Enemy basilisk;
        basilisk = new Enemy("Basilisk",1000,30,300);
        System.out.println("You are getting ready to fight the "+basilisk.getName());
        mygameMethod.battle2(basilisk);
        mystory.level2Outro();
        mygameMethod.anythingToContinue();
        mygameMethod.healWizard(wizard);
        mygameMethod.chooseUpgrade(wizard);
    }

    public void level3(){
        /* Level 3 */

        mygameMethod.place = 2;
        mygameMethod.gameLoop();
        mygameMethod.learnSpell(mygameMethod.setupSpells().get(4));
        mygameMethod.anythingToContinue();
        mystory.level3Intro();
        Enemy dementors;
        dementors = new Enemy("Dementor", 100, 40,50);
        System.out.println("You are getting ready to fight an army of "+dementors.getName());
        mygameMethod.battle3(dementors);
        mystory.level3Outro();
        mygameMethod.anythingToContinue();
        mygameMethod.healWizard(wizard);
    }

    public void level4(){
        /* Level 4 */

        mygameMethod.addPotion(mygameMethod.setupPotions().get(1));
        mygameMethod.place = 3;
        mygameMethod.chooseUpgrade(wizard);
        mygameMethod.learnSpell(mygameMethod.setupSpells().get(2));
        mygameMethod.gameLoop();
        mystory.level4Intro();
        Boss voldemort;
        voldemort = new Boss("Voldemort", 500, 170, 100, mygameMethod.setupForbiddenSpells(), null);
        Boss peter_pettigrew;
        peter_pettigrew = new Boss("Peter Pettigrew", 100, 130, 30, mygameMethod.setupForbiddenSpells(), null);
        mygameMethod.tutoDefend();
        System.out.println("You are getting ready to fight Voldemort and Peter Pettigrew. Keep in mind that your spell accio has as range 50m");
        System.out.println("Not sure you are strong enough to beat them... maybe you should try to run out");
        mygameMethod.battle4(voldemort, peter_pettigrew);
        mystory.level4Outro();
        mygameMethod.anythingToContinue();
        mygameMethod.healWizard(wizard);
    }

    public void level5(){
        /* Level 5 */

        mygameMethod.addPotion(mygameMethod.setupPotions().get(2));
        mygameMethod.place = 4;
        mygameMethod.chooseUpgrade(wizard);
        mygameMethod.learnSpell(mygameMethod.setupSpells().get(5));
        mygameMethod.gameLoop();
        mystory.level5Intro();
        mygameMethod.level5spellsKnown();
        Boss ombrage;
        ombrage = new Boss("Dolores Ombrage", 600, 160, 60, null, mygameMethod.level5spellsKnown());
        System.out.println("You will have to fight against Dolores Ombrage waiting for the other students to prepare fireworks");
        mygameMethod.anythingToContinue();
        System.out.println("You are getting ready to fight Dolores Ombrage");
        mygameMethod.anythingToContinue();
        mygameMethod.battle5(ombrage);
        mystory.level5Outro();
        mygameMethod.anythingToContinue();
        mygameMethod.healWizard(wizard);
    }

    public void level6(){
        /* Level 6 */

        mygameMethod.addPotion(mygameMethod.setupPotions().get(2));
        mygameMethod.place = 5;
        mygameMethod.chooseUpgrade(wizard);
        mygameMethod.learnSpell(mygameMethod.setupSpells().get(6));
        mygameMethod.gameLoop();
        mystory.level6Intro();

        Boss deathEater1;
        Boss deathEater2;
        Boss deathEater3;
        deathEater1 = new Boss("DeathEater1", 200,140,60, mygameMethod.setupForbiddenSpells(), null);
        deathEater2 = new Boss("DeathEater2", 200, 140, 60, mygameMethod.setupForbiddenSpells(), null);
        deathEater3 = new Boss("DeathEater3", 200, 140, 60, mygameMethod.setupForbiddenSpells(), null);
        System.out.println("You will fight 3 DeathEaters");
        mygameMethod.anythingToContinue();
        mygameMethod.battle6(deathEater1, deathEater2, deathEater3);
        mystory.level6Outro();
        mygameMethod.anythingToContinue();
        mygameMethod.healWizard(wizard);
        mygameMethod.deathEaterChoice();

    }

    public void level7(){
        /* Level 7 */

        mygameMethod.addPotion(mygameMethod.setupPotions().get(2));
        mygameMethod.place = 6;
        mygameMethod.chooseUpgrade(wizard);
        mygameMethod.gameLoop();

        if (!wizard.getDeathEater()) {
            mystory.level7Intro();
            Boss voldemort;
            voldemort = new Boss("Voldemort", 500, 180, 100, mygameMethod.setupForbiddenSpells(), null);
            Boss belatrix;
            belatrix = new Boss("Belatrix Lestrange", 400, 160, 80, mygameMethod.setupForbiddenSpells(), null);
            System.out.println("You are getting ready to fight Voldemort and Belatrix Lestrange");
            mygameMethod.anythingToContinue();
            mygameMethod.battle7(voldemort, belatrix);
            mygameMethod.anythingToContinue();
            mystory.level7Outro();
        } else if (wizard.getDeathEater()){
            mystory.level7Introbis();
            Boss potter;
            potter = new Boss("Harry Potter", 500, 180, 100, mygameMethod.setupForbiddenSpells(), null);
            Boss albus;
            albus = new Boss("Albus Dumbledore", 400, 160, 80, mygameMethod.setupForbiddenSpells(), null);
            System.out.println("You are getting ready to fight Harry Potter and Albus Dumbledore");
            mygameMethod.anythingToContinue();
            mygameMethod.battle7(potter, albus);
            mygameMethod.anythingToContinue();
            mystory.level7Outrobis();
        }

    }



}
