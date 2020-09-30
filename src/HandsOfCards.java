import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, HashSet<String>> game = new LinkedHashMap<>();

        while (!"JOKER".equals(input)){

            String[] tokens = input.split(": ");
            String playerName = tokens[0];
            String[] currentCards = tokens[1].split(", ");



            game.putIfAbsent(playerName, new HashSet<>());



            input = scanner.nextLine();
        }
    }
}
