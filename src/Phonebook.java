import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        while (!"search".equals(firstInput)) {
            String[] tokens = firstInput.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phonebook.put(name, number);

            firstInput = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!"stop".equals(secondInput)) {
            if (phonebook.containsKey(secondInput)) {
                System.out.println(String.format("%s -> %s", secondInput, phonebook.get(secondInput)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", secondInput));
            }

            secondInput = scanner.nextLine();

        }
    }
}