import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String nameOfTheStudent = scanner.nextLine();
            double[] marks = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            students.putIfAbsent(nameOfTheStudent, new double[marks.length]);
            students.put(nameOfTheStudent, marks);
        }

        students.entrySet()
                .stream()
                .forEach(s -> {
                    String name = s.getKey();
                    double averageMark = Arrays.stream(s.getValue()).average().getAsDouble();
                    DecimalFormat avr = new DecimalFormat("0.#################");
                    System.out.println(String.format("%s is graduated with %s", name, avr.format(averageMark)));
                });

    }
}
