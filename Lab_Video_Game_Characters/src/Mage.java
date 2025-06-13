public class Mage extends GameCharacter{
    private String spell;

    public Mage(String name, int health, int attackPower, String spell) {
        super(name, health, attackPower);
        this.spell = spell;
    }


    public String getSpell() {
        return spell;
    }

    @Override
    public void attack() {
        System.out.printf("The mage attacks with their %s spell dealing %d damage.%n", spell, attackPower);
    }
}
