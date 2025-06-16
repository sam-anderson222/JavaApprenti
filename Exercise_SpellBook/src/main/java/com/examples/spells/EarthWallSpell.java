package com.examples.spells;

import com.examples.Spell;

public class EarthWallSpell implements Spell {

    public void cast() {
        System.out.println("You raise a wall of earth in front of you, protecting you from attacks.");
    }

    public String getIncantation() {
        return "tierra";
    }

    public String getDescription() {
        return "You raise a wall of earth in front of you, protecting you from attacks.";
    }
}
