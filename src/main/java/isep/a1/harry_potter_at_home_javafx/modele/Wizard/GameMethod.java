package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.ForbiddenSpell;
import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wand.Core;
import isep.a1.harry_potter_at_home_javafx.modele.Wizard.Wand.Wand;

import java.util.*;

public class GameMethod {

    Scanner scanner = new Scanner(System.in);

    static public Wizard wizard;

    public int place = 0;
    public String[] places = {"Toilets", "Chamber of secrets", "Forbidden forest's lake", "Little Hangleton's graveyard", "Hogwarts examination room", "Astronomy Tower", "Hogwarts"};

    public boolean isRunning;

    public int readInt(String prompt, int userChoices){
        Scanner scanner = new Scanner(System.in);
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Enter an integer please");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    public void printSeperator(int n){
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public void clearConsole(){
        for(int i = 0; i<100; i++){
            System.out.println();
        }
    }

    public void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
    }

    public void anythingToContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a button to continue your journey");
        scanner.next();
    }

    public List<Potion> setupPotions(){
        List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Common Potion", 20));
        potions.add(new Potion("Rare Potion", 40));
        potions.add(new Potion("Legendary Potion", 60));

        return potions;
    }

    public List<Spell> setupSpells(){
        List<Spell> spells = new ArrayList<>();
        spells.add(new Spell("Expelliarmus",90, "Deal a small amount of damage but has a high accuracy", 20));
        spells.add(new Spell("Wingardium Leviosa", 100, "Make an object levitate. Can be used to break the defense of some enemies...", 0));
        spells.add(new Spell("Incendio", 70, "Launch a huge bullet of fire", 50));
        spells.add(new Spell("Accio", 100, "Attract an object to you", 0));
        spells.add(new Spell("Expecto Patronum", 100, "You launch your shining patronum, very useful against the dementors", 0));
        spells.add(new Spell("Stupefix", 80, "Deal a medium amount of damage and has a medium accuracy", 40));
        spells.add(new Spell("Sectusempra", 70, "A very strong spell that inflicts cuts", 70));

        return spells;
    }

    public List<ForbiddenSpell> setupForbiddenSpells(){
        List<ForbiddenSpell> forbiddenSpells = new ArrayList<>();
        forbiddenSpells.add(new ForbiddenSpell("Avada Kedavra",80, "Kill the one who is touched by this spell", 10000));
        forbiddenSpells.add(new ForbiddenSpell("Endoloris", 80, "Deal a great amount of damage to the target by making him suffer", 50));

        return forbiddenSpells;
    }

    public void spellsKnown(){
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(setupSpells().get(0));
        knownSpells.add(setupSpells().get(1));
        wizard.setSpellsKnown(knownSpells);
    }

    public void learnSpell(Spell spell){
        List<Spell> knownSpells = wizard.getSpellsKnown();
        knownSpells.add(spell);
        wizard.setSpellsKnown(knownSpells);
        System.out.println("You have just learnt "+spell.getName());
        anythingToContinue();
    }

    public List<Spell> level5spellsKnown(){
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(setupSpells().get(0));
        knownSpells.add(setupSpells().get(2));
        knownSpells.add(setupSpells().get(5));

        return knownSpells;
    }

    public void potionsOwned(){
        List<Potion> ownedPotions = new ArrayList<>();
        ownedPotions.add(setupPotions().get(0));
        ownedPotions.add(setupPotions().get(0));
        /*ownedPotions.add(Potion.setupPotions().get(1));*/
        wizard.setPotionsOwned(ownedPotions);
    }

    public void addPotion(Potion potion){
        List<Potion> ownedPotions = wizard.getPotionsOwned();
        ownedPotions.add(potion);
        wizard.setPotionsOwned(ownedPotions);
        System.out.println("You have got a "+potion.getName());
        anythingToContinue();
    }

    public List<House> setupHouse(){
        List<House> houses = new ArrayList<>();
        houses.add(new House("Slytherin"));
        houses.add(new House("Gryffindor"));
        houses.add(new House("Hufflepuff"));
        houses.add(new House("Ravenclaw"));

        return houses;
    }


    public void setupGame(){
        /* Setup Game */

        SortingHat mysortingHat = new SortingHat();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your wizard's name ? ");
        String name = scanner.nextLine();

        System.out.println("You are a young wizard and you want to be graduate from the best wizarding school of the country: Hogwarts. ");
        System.out.println("Before your first day, you have to get a pet, a house and a wand.");
        anythingToContinue();


        int size = 20 + (int) (Math.random() * ((35 - 20) + 1));

        Wand wand = new Wand(size, Core.assignCore());
        House house = mysortingHat.assignHouse();


        setupSpells();
        wizard = new Wizard(name, 100, 0, 0, house, Pet.assignPet(), wand, null, null);
        if (Objects.equals(wizard.getHouse().getName(), "Slytherin")) {
            wizard.setAtk(120);
        } else {
            wizard.setAtk(100);
        }
        if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
            wizard.setDef(120);
        }else{
            wizard.setDef(100);
        }
        anythingToContinue();
        spellsKnown();
        setupPotions();
        potionsOwned();

        System.out.println("Your name is " + wizard.name + ", your house is " + wizard.getHouse().getName() + ", your pet is a " + wizard.getPet() + ", your wand is made of " + wand.getCore() + " and its size is " + wand.getSize() + "cm");
        anythingToContinue();
        chooseUpgrade(wizard);
    }

    public void main(String[] args) {
        StartGame();
    }

    public void StartGame(){

        Level myLevel= new Level();

        setupGame();

        /* Level 1 */

        myLevel.level1();

        /* Level 2 */

        myLevel.level2();

        /* Level 3 */

        myLevel.level3();

        /* Level 4 */

        myLevel.level4();

        /* Level 5 */

        myLevel.level5();

        /* Level 6 */

        myLevel.level6();

        /* Level 7 */

        myLevel.level7();
    }

    public static void continueJourney(){
    }

    public void characterInfo(){
        printHeading("Character info");
        System.out.println(wizard.name);
        System.out.println("Stats: HP: "+wizard.maxHp+" ATK: " + wizard.atk + " DEF: "+wizard.def);
        System.out.println("House: "+wizard.getHouse().getName());
        System.out.println("Pet: "+wizard.getPet());
        anythingToContinue();
    }

    public void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action");
        printSeperator(20);
        System.out.println("1: Continue your journey");
        System.out.println("2: Known Spells");
        System.out.println("3: Character Info");
        System.out.println("4: Exit game");
    }

    public void gameLoop(){
        isRunning = true;
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 4);
            if (input == 1) {
                isRunning = false;
            }else if(input == 2) {
                printSpells(wizard.getSpellsKnown());
            } else if (input == 3) {
                characterInfo();
            }else {
                System.exit(1);
            }
        }
    }

    public void printSpells(List<Spell> spells) {
        for (Spell spell : spells) {
            System.out.println(spell.getName().toString());
            System.out.println("Effect: "+spell.getEffect().toString());
            System.out.println("Accuracy: "+spell.getAccuracy());
            System.out.println("Damage: "+spell.getDamage());
            printSeperator(20);
        }
        anythingToContinue();
    }

    public void printPotions(List<Potion> potions) {
        int i = 0;
        for (Potion potion : potions) {
            i+=1;
            System.out.println("("+i+") " + potion.getName()+ " restores "+ potion.getHp()+" HP");
        }
    }

    public void removePotionList(int i) {
        List<Potion> ownedPotions = wizard.getPotionsOwned();
        ownedPotions.remove(i);
        wizard.setPotionsOwned(ownedPotions);
    }

    public void battle1(Enemy enemy){
        boolean fight=true;
        while(fight) {
            printHeading(enemy.name + "\nHP: " + enemy.getHp() + "/" + enemy.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa");
                int input1 = readInt("-> ", 2);
                if (input1 == 1) {
                    int damage;
                    damage = wizard.attack(wizard.getSpellsKnown().get(0), enemy);
                    enemy.takeDamage(damage);
                    anythingToContinue();
                } else if (input1 == 2) {
                    int damage;
                    damage = wizard.attack(wizard.getSpellsKnown().get(1), enemy);
                    enemy.takeDamage(damage);
                    enemy.setDef(0);
                    System.out.println("You broke his defense! Try now to use an offensive spell");
                    anythingToContinue();
                }
            }else if (input == 2){
                /* faire la partie avec les potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
                /*wizard.setPotionsOwned(wizard.getPotionsOwned().remove(potionnum-1));*/

            }else if (input == 3){
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }

            if (enemy.getHp() <= 0) {
                fight = false;
            }

            if (fight) {
                int damage1;
                damage1 = enemy.attack1(wizard);
                wizard.takeDamage(damage1);
            }

            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
            }
        }
    }

    public void battle2(Enemy enemy){
        boolean fight=true;
        while(fight) {
            printHeading(enemy.name + "\nHP: " + enemy.getHp() + "/" + enemy.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio");
                int input1 = readInt("-> ", 3);
                if (input1 == 1) {
                    int damage;
                    damage = wizard.attack(wizard.getSpellsKnown().get(0), enemy);
                    enemy.takeDamage(damage);
                    anythingToContinue();
                } else if (input1 == 2) {
                    System.out.println("You have nothing to make levitate right now...");
                    anythingToContinue();
                } else if (input1 == 3) {
                    if (Objects.equals(wizard.getHouse().getName(), "Gryffindor")){
                        System.out.println("You just have grabbed the legendary Godric Gryffindor's sword!");
                        System.out.println("You now just can kill the Basilisk easily and destroy the diary.");
                        anythingToContinue();
                        enemy.setHp(0);
                    }else {
                        System.out.println("You just have grabbed a Basilisk's fang but you will have to survive a few attacks before reaching the diary since you can't use accio on it beacause it is a legendary artefact");
                        for(int i = 1; i<=3; i++){

                            if (i==1){
                                int damage1;
                                damage1 = enemy.attack1(wizard);
                                wizard.takeDamage(damage1);
                                System.out.println("You are still far to the diary, you are walking to it but the basilisk is still atacking");
                                System.out.println("You still have "+wizard.getHp()+" HP");
                                anythingToContinue();
                            }
                            if (i==2){
                                int damage1;
                                damage1 = enemy.attack1(wizard);
                                wizard.takeDamage(damage1);
                                System.out.println("You are getting closer");
                                System.out.println("You still have "+wizard.getHp()+" HP");
                                anythingToContinue();
                            }
                            if (i==3){
                                System.out.println("You finally reached it!");
                                anythingToContinue();
                            }

                            if (wizard.getHp() <= 0) {
                                System.out.println("You died");
                                anythingToContinue();
                                System.exit(1);
                                fight = false;
                            }

                        }


                    }
                    System.out.println("The basilisk is dead, you have beat him!");
                    fight=false;
                }
            }else if (input == 2) {
                /* faire les bails des potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            }else if (input == 3){
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }

            if (enemy.getHp() <= 0) {
                fight = false;
            }

            if (fight) {
                int damage1;
                damage1 = enemy.attack1(wizard);
                wizard.takeDamage(damage1);
            }


            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }
        }
    }

    public void battle3(Enemy enemy){
        boolean fight=true;
        int i = 0;
        int j = 0;
        while(fight) {
            printHeading(enemy.name + "\nHP: " + enemy.getHp() + "/" + enemy.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Take care! The dementors are coming for you, if you don't find a solution in the next instants, they will defeat you! ");
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum");
                int input1 = readInt("-> ", 4);
                if (input1 == 4){
                    i += 1;
                    if (i == 1){
                        System.out.println("You are not focus enough, you should try again.");
                    } else if (i == 2){
                        System.out.println("You are close to succeed, let's try again, it should work this time!");
                    } else if (i == 3){
                        System.out.println("You succeeded! Your spell was perfect, you have reject the terrible dementors");
                        enemy.setHp(0);
                        anythingToContinue();
                    }
                } else {
                    System.out.println("The spell didn't work ! It seems that it passed through the dementors");
                }

            }else if (input == 2){
                /* faire la partie avec les potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            }else if (input == 3){
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }

            if (enemy.getHp() <= 0) {
                fight = false;
            }

            j += 1;
            if (j == 1){
                System.out.println("The dementors are coming for you, you have to push them away");
            } else if (j == 2){
                System.out.println("The dementors are now closer");
            } else if (j == 3){
                System.out.println("The dementors are now really close! It's becoming urgent!");
            } else if (j == 4){
                System.out.println("They now almost can touch you!");
            } else if (j == 5){
                System.out.println("You have not succeeded to push them away... They got you");
                wizard.setHp(0);
            }

            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }
        }
    }


    public void battle4(Boss boss, Boss boss1) {
        Random rand = new Random();
        boolean fight=true;
        boolean dead=false;
        boolean dead1=false;
        int distance = 100;
        while(fight) {
            distance = distance - 10;
            if (distance <= 0){
                distance = 0;
            }
            printHeading(boss.name + "\nHP: " + boss.getHp() + "/" + boss.maxHp);
            printHeading(boss1.name + "\nHP: " + boss1.getHp() + "/" + boss1.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("You are "+distance+"m from the trophy");
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio");
                int input1 = readInt("-> ", 5);
                if (input1==3){
                    if (distance <= 50){
                        System.out.println("You were close enough! You have grabbed the trophy.");
                        anythingToContinue();
                        fight=false;
                    } else if (distance >= 60){
                        System.out.println("You were not close from the trophy enough.");
                    }
                } else{
                    System.out.println("Who do you want to attack?");
                    System.out.println("(1) Voldemort\n(2) Peter Pettigrew");
                    int input2 = readInt("->", 2);
                    if (input2==1) {
                        if (dead) {
                            System.out.println(boss.getName()+" is already dead");
                        }else {
                            int damage;
                            damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss);
                            if (damage <= 0) {
                                damage = 0;
                            }
                            boss.takeDamage(damage);
                            anythingToContinue();
                        }
                    } else if (input2==2) {
                        if (dead1) {
                            System.out.println(boss1.getName()+" is already dead");
                        }else {
                            int damage;
                            damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss1);
                            if (damage <= 0) {
                                damage = 0;
                            }
                            boss1.takeDamage(damage);
                            anythingToContinue();
                        }
                    }
                }
            } else if (input == 2){
                /* faire potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3){
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }

            if (boss.getHp() <= 0) {
                System.out.println("Voldemort is beaten");
                dead = true;
            }

            if (boss1.getHp() <= 0) {
                System.out.println("Peter Pettigrew is dead");
                dead1 = true;
            }

            if (dead & dead1){
                fight = false;
            }

            int spell1 = rand.nextInt(2)+1;
            int spell2 = rand.nextInt(2)+1;

            if (fight) {
                if (!dead) {
                    int damage1;
                    damage1 = boss.attack2(boss.getSpellsKnown().get(spell1 - 1), wizard);
                    wizard.takeDamage(damage1);
                }
            }

            if (fight) {
                if (!dead1) {
                    int damage2;
                    damage2 = boss1.attack2(boss1.getSpellsKnown().get(spell2 - 1), wizard);
                    wizard.takeDamage(damage2);
                }
            }

            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

        }
    }

    public void battle5(Boss boss){
        Random rand = new Random();
        boolean fight=true;
        int i = 0;
        while(fight) {
            i += 1;
            printHeading(boss.name + "\nHP: " + boss.getHp() + "/" + boss.maxHp);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio\n(6) Stupefix");
                int input1 = readInt("-> ", 6);
                int damage;
                damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss);
                if (damage<=0){
                    damage = 0;
                }
                boss.takeDamage(damage);
                anythingToContinue();
            } else if (input == 2){
                /* faire potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3){
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }

            if (boss.getHp() <= 0) {
                System.out.println(boss.getName()+" is beaten");
                fight = false;
            }

            int spell1 = rand.nextInt(3)+1;

            if (fight) {
                int damage1;
                damage1 = boss.attack(wizard, boss.getAuthorizedSpellsKnown().get(spell1 - 1));
                wizard.takeDamage(damage1);
            }

            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

            if (i==5){
                fight = false;
            }

        }
    }

    public void battle6(Boss boss1, Boss boss2, Boss boss3) {
        Random rand = new Random();
        boolean fight = true;
        boolean dead1 = false;
        boolean dead2 = false;
        boolean dead3 = false;
        while (fight) {
            printHeading(boss1.name + "\nHP: " + boss1.getHp() + "/" + boss1.maxHp);
            printHeading(boss2.name + "\nHP: " + boss2.getHp() + "/" + boss2.maxHp);
            printHeading(boss3.name + "\nHP: " + boss3.getHp() + "/" + boss3.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio\n(6) Stupefix\n(7) Sectusempra");
                int input1 = readInt("-> ", 7);
                System.out.println("Who do you want to attack?");
                System.out.println("(1) DeathEater1\n(2) DeathEater2\n(3) DeathEater3");
                int input2 = readInt("->", 10);
                if (input2 == 1) {
                    if (dead1) {
                        System.out.println(boss1.getName()+" is already dead");
                    }else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss1);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss1.takeDamage(damage);
                        anythingToContinue();
                    }
                } else if (input2 == 2) {
                    if (dead2) {
                        System.out.println(boss2.getName()+" is already dead");
                    }else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss2);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss2.takeDamage(damage);
                        anythingToContinue();
                    }
                } else if (input2 == 3){
                    if (dead3) {
                        System.out.println(boss3.getName()+" is already dead");
                    } else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss3);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss3.takeDamage(damage);
                        anythingToContinue();
                    }
                }
            }else if (input == 2){
                /* faire potions */
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3) {
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }


            if (boss1.getHp() <= 0) {
                System.out.println("DeathEater1 is dead");
                dead1 = true;
            }

            if (boss2.getHp() <= 0) {
                System.out.println("DeathEater2 is dead");
                dead2 = true;
            }

            if (boss3.getHp() <= 0) {
                System.out.println("DeathEater3 is dead");
                dead3 = true;
            }

            if (dead1 & dead2 & dead3){
                fight = false;
            }

            int spell1 = rand.nextInt(2)+1;
            int spell2 = rand.nextInt(2)+1;
            int spell3 = rand.nextInt(2)+1;

            if (fight) {
                if (!dead1) {
                    int damage1;
                    damage1 = boss1.attack2(boss1.getSpellsKnown().get(spell1 - 1), wizard);
                    wizard.takeDamage(damage1);
                }
            }

            if (fight) {
                if (!dead2) {
                    int damage2;
                    damage2 = boss2.attack2(boss2.getSpellsKnown().get(spell2 - 1), wizard);
                    wizard.takeDamage(damage2);
                }
            }

            if (fight) {
                if (!dead3) {
                    int damage3;
                    damage3 = boss3.attack2(boss3.getSpellsKnown().get(spell3-1), wizard);
                    wizard.takeDamage(damage3);
                }
            }

            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

        }
    }

    public void battle7(Boss boss1, Boss boss2){
        Random rand = new Random();
        boolean fight=true;
        boolean dead1=false;
        boolean dead2=false;
        while(fight) {
            printHeading(boss1.name + "\nHP: " + boss1.getHp() + "/" + boss1.maxHp);
            printHeading(boss2.name + "\nHP: " + boss2.getHp() + "/" + boss2.maxHp);
            printSeperator(30);
            System.out.println("VS");
            printHeading(wizard.name + "\nHP: " + wizard.getHp() + "/" + wizard.maxHp);
            System.out.println("Choose an action");
            printSeperator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Surrender");
            int input = readInt("-> ", 3);
            if (input == 1) {
                System.out.println("Which spell you want to use?");
                System.out.println("(1) Expelliarmus\n(2) Wingardium Leviosa\n(3) Accio\n(4) Expecto Patronum\n(5) Incendio\n(6) Stupefix\n(7) Sectusempra");
                int input1 = readInt("-> ", 7);
                System.out.println("Who do you want to attack?");
                System.out.println("(1) " + boss1.getName()+"\n(2) "+boss2.getName());
                int input2 = readInt("->", 2);
                if (input2==1) {
                    if (dead1){
                        System.out.println(boss1.getName()+" is already dead");
                    }else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss1);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss1.takeDamage(damage);
                        anythingToContinue();
                    }
                } else if (input2==2) {
                    if (dead2){
                        System.out.println(boss2.getName()+" is already dead");
                    } else {
                        int damage;
                        damage = wizard.attack(wizard.getSpellsKnown().get(input1 - 1), boss2);
                        if (damage <= 0) {
                            damage = 0;
                        }
                        boss2.takeDamage(damage);
                        anythingToContinue();
                    }
                }

            } else if (input == 2){
                System.out.println(wizard.getPotionsOwned().size());
                printPotions(wizard.getPotionsOwned());
                System.out.println("Choose the potion you want to drink: ");
                int potionnum = readInt("->", wizard.getPotionsOwned().size());
                Potion.drinkPotion(wizard,wizard.getPotionsOwned().get(potionnum-1));
                removePotionList(potionnum-1);
            } else if (input == 3){
                System.out.println("You have surrendered, you will exit the game");
                System.exit(1);
            }

            if (boss1.getHp() <= 0) {
                System.out.println(boss1.getName()+" is dead");
                dead1 = true;
            }

            if (boss2.getHp() <= 0) {
                System.out.println(boss2.getName() + " is dead");
                dead2 = true;
            }

            if (dead1 & dead2){
                fight = false;
            }

            int spell1 = rand.nextInt(2)+1;
            int spell2 = rand.nextInt(2)+1;

            if (fight) {
                if (!dead1) {
                    int damage1;
                    damage1 = boss1.attack2(boss1.getSpellsKnown().get(spell1 - 1), wizard);
                    wizard.takeDamage(damage1);
                }
            }

            if (fight) {
                if (!dead2) {
                    int damage2;
                    damage2 = boss2.attack2(boss2.getSpellsKnown().get(spell2 - 1), wizard);
                    wizard.takeDamage(damage2);
                }
            }

            if (wizard.getHp() <= 0) {
                System.out.println("You died");
                anythingToContinue();
                System.exit(1);
                fight = false;
            }

        }
    }

    public void chooseUpgrade(Wizard wizard){
        printHeading("Choose an upgrade");
        System.out.println("1: Attack upgrade");
        System.out.println("2: Defense upgrade");
        int input = readInt("-> ", 2);
        if(input ==1){
            printHeading("You chose the Attack upgrade");
            wizard.setAtk(wizard.getAtk()+10);
        }else{
            printHeading("You chose the Defense upgrade");
            wizard.setDef(wizard.getDef()+10);
        }
        anythingToContinue();
    }

    public void healWizard(Wizard wizard){
        wizard.setHp(wizard.getMaxhp());
    }

    public void tutoDefend(){
        System.out.println("You will now learn the spell Protego.");
        System.out.println("This spell won't be used to attack but to defend when your enemies will attack you");
        System.out.println("You will have to write 'defend' in the console in less than 4 seconds");
        System.out.println("Get Ready!");
        anythingToContinue();
        boolean defend = Wizard.defend();
        if (defend){
            System.out.println("You have succeeded");
        } else{
            System.out.println("You failed");
        }
        anythingToContinue();
    }

    public void deathEaterChoice(){
        boolean deatheater = false;
        if (Objects.equals(wizard.getHouse().getName(), "Slytherin")){
            System.out.println("You have just killed 3 Deatheaters.");
            System.out.println("However, you have a vision of voldemort asking you to join his ranks");
            System.out.println("Do you accept? ");
            System.out.println("(1) Yes\n(2) No");
            int choose = readInt("->", 2);
            if (choose == 1){
                deatheater = true;
                System.out.println("You have chosen the deatheaters rank");
                anythingToContinue();
                wizard.setDeathEater(deatheater);
            }
        }
    }

}
