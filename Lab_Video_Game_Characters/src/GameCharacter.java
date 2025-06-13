// Character is the name of the char class.
public class GameCharacter {
    protected String name;
    protected int health;
    protected int attackPower;

    public GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    // These getters will be inherited by the subclasses
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }


    public void attack() {
        System.out.printf("The character attacks dealing %d damage.%n", attackPower);
    }
}
