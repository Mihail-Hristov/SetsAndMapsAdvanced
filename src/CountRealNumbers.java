import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(e ->{
                    numbers.putIfAbsent(e, 0);
                    numbers.put(e, numbers.get(e) + 1);
                });



        String output = numbers.entrySet()
                .stream()
                .map(n -> String.format("%.1f -> %d", n.getKey(),n.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(output);
    }
}
