import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String studentName = tokens[0];

            double mark = Double.parseDouble(tokens[1]);

            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(mark);
            students.put(studentName, students.get(studentName));

        }

        students.entrySet()
                .stream()
                .forEach(e -> {
                    String student = e.getKey();
                    System.out.print(student + " -> ");
                    for (double mark : e.getValue()) {

                        System.out.print(String.format("%.2f ", mark));
                    }
                    double averageGrade = e.getValue()
                            .stream()
                            .mapToDouble(m -> m)
                            .average()
                            .getAsDouble();

                    System.out.println(String.format("(avg: %.2f)",averageGrade));
                    });

    }
}
