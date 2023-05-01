package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.ForbiddenSpell;
import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;

import java.util.List;

public class Boss extends AbstractEnemy {
    private List spellsKnown;
    private List authorizedSpellsKnown;
    public Boss(String name, int maxHp, int atk, int def, List spellsKnown, List authorizedSpellsKnown) {
        super(name, maxHp, atk, def);
        this.spellsKnown = spellsKnown;
        this.authorizedSpellsKnown = authorizedSpellsKnown;
    }

    public List<ForbiddenSpell> getSpellsKnown() {
        return spellsKnown;
    }

    public void setSpellsKnown(List<ForbiddenSpell> knownSpells) {
        this.spellsKnown = knownSpells;
    }

    public List<Spell> getAuthorizedSpellsKnown() {
        return authorizedSpellsKnown;
    }

    public void setAuthorizedSpellsKnown(List<Spell> authorizedSpellsKnown) {
        this.authorizedSpellsKnown = authorizedSpellsKnown;
    }

    @Override
    public int attack1(Character character) {
        return 0;
    }

    @Override
    public int attack2(ForbiddenSpell forbiddenSpell, Character character) {
        int damage = forbiddenSpell.getDamage() * (getAtk() - character.getDef())  * 1/100;
        if (damage <= 0){
            damage = 0;
        }
        System.out.println(getName()+" Attacked you with "+forbiddenSpell.getName()+" and dealt you "+damage);
        if (!Wizard.defend()){
            System.out.println("You took the damage");
        } else{
            System.out.println("You have used Protego! You don't receive any damage.");
            damage = 0;
        }
        return damage;
    }

    @Override
    public int attack(Character character, Spell spell){
        int damage = spell.getDamage() * (getAtk() - character.getDef()/2)  * 1/100;
        if (damage <= 0){
            damage = 0;
        }
        System.out.println(getName()+" Attacked you with "+spell.getName()+" and dealt you "+damage);
        if (!Wizard.defend()){
            System.out.println("You took the damage");
        } else{
            System.out.println("You have used Protego! You don't receive any damage.");
            damage = 0;
        }
        return damage;
    }

    public void takeDamage(int damage){
        setHp(getHp()-damage);
        if (getHp() <= 0){
            setHp(0);
        }

    }




}