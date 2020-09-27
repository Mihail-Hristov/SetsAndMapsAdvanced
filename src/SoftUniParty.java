import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputForReservationList = scanner.nextLine();

        TreeSet<String> guests = new TreeSet<>();

        while (!"PARTY".equals(inputForReservationList)){
            guests.add(inputForReservationList);

            inputForReservationList = scanner.nextLine();
        }

        String currentGuest = scanner.nextLine();

        while (!"END".equals(currentGuest)) {
            guests.remove(currentGuest);

            currentGuest = scanner.nextLine();
        }

        int countNotComingGuest = guests.size();
        System.out.println(countNotComingGuest);
        System.out.println(String.join(System.lineSeparator(), guests));

    }
}
