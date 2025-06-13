import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GameCharacter> gameCharacters = new ArrayList<>();

        // Creating game characters
        gameCharacters.add(new Warrior("Barbarian", 110, 15, "War Mace"));
        gameCharacters.add(new Archer("Sniper", 75, 18, "Heavy Crossbow"));
        gameCharacters.add(new Mage("Shaman", 100, 20, "Rain Fire"));
        gameCharacters.add(new GameCharacter("Generic Character", 10, 10));

        // printing each attack message.
        for (int i = 0; i < gameCharacters.size(); i++) {
            gameCharacters.get(i).attack();
        }


    }
}
