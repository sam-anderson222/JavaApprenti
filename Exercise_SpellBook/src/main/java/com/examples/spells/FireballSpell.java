package com.examples.spells;

import com.examples.Spell;

public class FireballSpell implements Spell {
    public void cast() {
        System.out.println("You shoot a fireball at your enemies.");
    }

    public String getIncantation() {
        return "fuego";
    }
}
