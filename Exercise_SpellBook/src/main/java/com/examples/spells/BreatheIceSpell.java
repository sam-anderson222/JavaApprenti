package com.examples.spells;

import com.examples.Spell;

public class BreatheIceSpell implements Spell {
    public void cast() {
        System.out.println("You breathe a mist of razor-sharp ice from your mouth.");
    }

    public String getIncantation() {
        return "frio";
    }
}
