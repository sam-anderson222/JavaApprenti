package com.examples.spells;

import com.examples.Spell;

public class GrowSpell implements Spell {
    public void cast() {
        System.out.println("A green light envelopes the all the plants around you. The plants rapidly ages until they reach full maturity.");
    }

    public String getIncantation() {
        return "planta";
    }

    public String getDescription() {
        return "A green light envelopes the all the plants around you. The plants rapidly ages until they reach full maturity.";
    }
}
