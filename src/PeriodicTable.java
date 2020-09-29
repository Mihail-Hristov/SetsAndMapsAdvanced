import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < numberOfLine; i++) {
            String[] currentInput = scanner.nextLine().split("\\s+");

            for (int j = 0; j < currentInput.length; j++) {
                elements.add(currentInput[j]);
            }
        }

        String output =elements.stream()
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
