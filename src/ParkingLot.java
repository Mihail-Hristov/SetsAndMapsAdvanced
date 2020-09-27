import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (!"END".equals(input)) {

            String[] token = input.split(", ");

            String direction = token[0];
            String currentCarNumber = token[1];

            switch (direction){
                case "IN":
                    cars.add(currentCarNumber);

                    break;
                case "OUT":
                    cars.remove(currentCarNumber);

                    break;
            }


            input = scanner.nextLine();

        }

        boolean parkingIsEmpty = checkParking(cars);

        if (parkingIsEmpty){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }

    public static boolean checkParking(HashSet<String> cars){

        return cars.isEmpty();
    }
}
