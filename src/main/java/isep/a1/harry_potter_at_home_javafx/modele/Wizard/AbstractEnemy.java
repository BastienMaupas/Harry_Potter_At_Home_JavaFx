package isep.a1.harry_potter_at_home_javafx.modele.Wizard;

import isep.a1.harry_potter_at_home_javafx.modele.Spell.Spell;

public abstract class AbstractEnemy extends Character {
    public AbstractEnemy(String name, int maxHp, int atk, int def) {
        super(name, maxHp, atk, def);
    }

    public abstract int attack1(Character character);

    public abstract int attack(Character character, Spell spell);
}

