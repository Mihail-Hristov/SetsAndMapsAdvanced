import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> names = new LinkedHashSet<>();

        for (int i = 0; i < numberOfLines; i++) {
            String currentName = scanner.nextLine();
            names.add(currentName);
        }


        for (String name : names) {
            System.out.println(name);
        }

    }
}
