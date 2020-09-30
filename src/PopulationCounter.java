import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Map<String, Long>> populations = new LinkedHashMap<>();

        while (!"report".equals(input)){
            String[] tokens = input.split("\\|");

            String country = tokens[1];
            String city = tokens[0];
            Long population = Long.parseLong(tokens[2]);

            populations.putIfAbsent(country, new LinkedHashMap<>());
            populations.get(country).put(city, population);

            input = scanner.nextLine();
        }

        populations.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                        Long first = e1.getValue().values().stream().mapToLong(Math::toIntExact).sum();
                        Long second = e2.getValue().values().stream().mapToLong(Math::toIntExact).sum();
                        return  Long.compare(second, first);
                }).forEach(e -> {
                    String country = e.getKey();
                    Long totalPopulation = e.getValue().values().stream().mapToLong(Math::toIntExact).sum();
                    System.out.println(String.format("%s (total population: %d)", country, totalPopulation));
                    e.getValue().entrySet()
                            .stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(c -> {
                                String city = c.getKey();
                                Long population = c.getValue();
                                System.out.println(String.format("=>%s: %d", city, population));
                            });
        });

    }
}
