import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        int count = 0;
        String input = scanner.nextLine();
        String name = "";

        while (!"stop".equals(input)){
            count ++;

            if (count % 2 != 0){
                emails.putIfAbsent(input, "");
            }else {
                emails.put(name, input);
            }

            name = input;

            input = scanner.nextLine();
        }



        emails.entrySet()
                .stream()
                .forEach(e -> {
                    String[] tokens = e.getValue().split("\\.");
                    String extension = tokens[tokens.length - 1];
                    if (extension.toUpperCase().equals("COM") || extension.toUpperCase().equals("US") || extension.toUpperCase().equals("UK")){
                    }else {
                        System.out.println(String.format("%s -> %s", e.getKey(), e.getValue()));
                    }
                });

    }
}
