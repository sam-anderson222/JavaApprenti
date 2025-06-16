package com.examples.spells;

import com.examples.Spell;

public class AlluringMelodySpell implements Spell {
    public void cast() {
        System.out.println("A comforting melody echoes throughout the air. Your enemies are entranced by it.");
    }

    public String getIncantation() {
        return "melodia";
    }

    public String getDescription() {
        return "A comforting melody echoes throughout the air. Your enemies are entranced by it.";
    }
}
