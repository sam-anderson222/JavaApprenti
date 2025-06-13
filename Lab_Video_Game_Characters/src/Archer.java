public class Archer extends GameCharacter{
    private String bowType;

    public Archer(String name, int health, int attackPower, String bowType) {
        super(name, health, attackPower);
        this.bowType = bowType;
    }


    public String getBowType() {
        return bowType;
    }

    @Override
    public void attack() {
        System.out.printf("The archer snipes with their %s dealing %d damage.%n", bowType, attackPower);
    }
}

