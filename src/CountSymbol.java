import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputtedText = scanner.nextLine();

        TreeMap<Character, Integer> charCounter = new TreeMap<>();

        for (int i = 0; i < inputtedText.length(); i++) {
            char currentChar = inputtedText.charAt(i);

            charCounter.putIfAbsent(currentChar, 0);
            int currentCount = charCounter.get(currentChar) + 1;
            charCounter.put(currentChar, currentCount);
        }

        charCounter.entrySet()
                .stream()
                .forEach(c -> {
                    System.out.println(String.format("%c: %d time/s", c.getKey(), c.getValue()));
                });
    }
}
