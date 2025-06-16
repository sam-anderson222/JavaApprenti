package com.examples.spells;

import com.examples.Spell;

public class ConjureSwordSpell implements Spell {
    public void cast() {
        System.out.println("An iron sword materializes in your hand.");
    }

    public String getIncantation() {
        return "espada";
    }

    public String getDescription() {
        return "An iron sword materializes in your hand.";
    }
}
