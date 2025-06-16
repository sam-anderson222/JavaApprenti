package com.examples;
import com.examples.spells.*;

import java.util.ArrayList;

public class SpellBook {
    private ArrayList<Spell> spells;

    public SpellBook() {
        // Adding spells to the spell book
        spells = new ArrayList<>();
        spells.add(new BreatheIceSpell());
        spells.add(new FireballSpell());
        spells.add(new GrowSpell());
        spells.add(new ResurrectSpell());
        spells.add(new LightArrowSpell());
        spells.add(new AlluringMelodySpell());
        spells.add(new EarthWallSpell());
        spells.add(new ConjureSwordSpell());
        spells.add(new ExitSpell());
    }


    public void tryIncantation(String incantation) {
        // Loop through incantation
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getIncantation().equalsIgnoreCase(incantation)) {
                spells.get(i).cast(); // Cast the spell if the incantation is found.
                return;
            }
        }

        // If incantation is not found then print a generic failure message.
        TerminalUtils.printMessage("The spell fizzled out! Try again.");
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }
}
