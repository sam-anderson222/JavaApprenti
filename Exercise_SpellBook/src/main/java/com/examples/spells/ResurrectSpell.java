package com.examples.spells;

import com.examples.Spell;

public class ResurrectSpell implements Spell {
    public void cast() {
        System.out.println("A shimmering light blankets the ground in front of you. The dead rises from the soil.");
    }

    public String getIncantation() {
        return "muerto";
    }

    public String getDescription() {
        return "A shimmering light blankets the ground in front of you. The dead rises from the soil.";
    }
}
