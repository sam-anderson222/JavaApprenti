package com.examples.spells;

import com.examples.Spell;

public class LightArrowSpell implements Spell {
    public void cast() {
        System.out.println("You shoot an arrow of shining brilliance at your enemies.");
    }

    public String getIncantation() {
        return "luminoso";
    }

    public String getDescription() {
        return "You shoot an arrow of shining brilliance at your enemies.";
    }
}
