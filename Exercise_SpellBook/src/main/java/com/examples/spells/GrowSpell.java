package com.examples.spells;

import com.examples.Spell;

public class GrowSpell implements Spell {
    public void cast() {
        System.out.println("A green light envelopes the sapling in front of you. The plant rapidly ages until it reach full maturity.");
    }

    public String getIncantation() {
        return "planta";
    }
}
