package com.examples.spells;
import com.examples.Spell;

public class ExitSpell implements Spell{
    public void cast() {
        System.out.println("A portal opens beneath you. Goodbye, wizard!");
        System.exit(0);
    }

    public String getIncantation() {
        return "exit";
    }

}
