import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInput = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> earth = new LinkedHashMap<>();

        for (int i = 0; i < numberOfInput; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continentName = tokens[0];
            String countryName = tokens[1];
            String cityName = tokens[2];

            earth.putIfAbsent(continentName, new LinkedHashMap<>());
            earth.get(continentName).putIfAbsent(countryName, new ArrayList<>());
            earth.get(continentName).get(countryName).add(cityName);

        }

        earth.entrySet()
                .stream()
                .forEach(entry -> {
                    String continent = entry.getKey();
                    System.out.println(String.format("%s:", continent));
                    entry.getValue().entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                String country = innerEntry.getKey();
                                String cities = innerEntry.getValue().toString().replaceAll("[\\]\\[]", "");
                                System.out.println(String.format("  %s -> %s", country, cities));
                            });
                });

    }
}
