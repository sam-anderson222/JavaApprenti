public class Warrior extends GameCharacter{
    private String weaponType;

    public Warrior(String name, int health, int attackPower, String weaponType) {
        super(name, health, attackPower);
        this.weaponType = weaponType;
    }


    public String getWeaponType() {
        return weaponType;
    }

    @Override
    public void attack() {
        System.out.printf("The warrior attacks with their %s dealing %d damage.%n", weaponType, attackPower);
    }
}
