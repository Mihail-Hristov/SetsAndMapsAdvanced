import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, Map<String, Double>> shops = new TreeMap<>();

        while (!"Revision".equals(input)){
            String[] tokens = input.split(", ");
            String shopName = tokens[0];
            String productName = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).putIfAbsent(productName, 0.00);
            shops.get(shopName).put(productName, price);

            input = scanner.nextLine();
        }

        shops.entrySet()
                .stream()
                .forEach(s -> {
                    String shop = s.getKey();
                    System.out.println(String.format("%s->", shop));
                    s.getValue().entrySet()
                            .stream()
                            .forEach(s2 -> {
                                String product = s2.getKey();
                                double price = s2.getValue();
                                System.out.println(String.format("Product: %s, Price: %.1f", product, price));
                            });

                });

    }
}
