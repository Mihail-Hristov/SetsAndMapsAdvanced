import java.util.Arrays;
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
            game.get(playerName).addAll(Arrays.asList(currentCards));

            input = scanner.nextLine();
        }

        game.entrySet()
                .stream()
                .forEach(g -> {
                    String name = g.getKey();
                    int value = 0;
                    for (String item : g.getValue()) {
                        int type = readType(item);
                        int power = readPower(item);

                        int currentSum = power * type;
                        value += currentSum;
                    }
                    System.out.println(String.format("%s: %d", name, value));

                });

    }

    public static int readType(String item){
        int type = 0;

        if (item.charAt(item.length() - 1) == 'S') {
            type = 4;
        }else if (item.charAt(item.length() - 1) == 'H'){
            type = 3;
        }else if(item.charAt(item.length() - 1) == 'D'){
            type = 2;
        }else if (item.charAt(item.length() - 1) == 'C'){
            type = 1;
        }

        return type;
    }

    public static int readPower(String item){
        int power = 0;
        String powerAsString = item.substring(0, item.length() - 1);
        if (powerAsString.equals("J")){
            power = 11;
        }else if (powerAsString.equals("Q")){
            power = 12;
        }else if (powerAsString.equals("K")){
            power = 13;
        }else if (powerAsString.equals("A")){
            power = 14;
        }else {
            power = Integer.parseInt(powerAsString);
        }

        return power;
    }
}
