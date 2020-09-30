import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstLoop = tokens[0];
        int secondLoop = tokens[1];

        int numberOfLines = firstLoop + secondLoop;

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> finalSet = new LinkedHashSet<>();

        for (int i = 0; i < numberOfLines; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (i < firstLoop) {
                firstSet.add(currentNumber);
            } else {
                secondSet.add(currentNumber);
            }
        }

        firstSet.retainAll(secondSet);

        for (int number : firstSet) {
            System.out.print(number + " ");
        }
    }
}
