import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLine = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> logsWithDuration = new TreeMap<>();
        TreeMap<String, TreeSet<String>> logsWithIP = new TreeMap<>();

        for (int i = 0; i < numberOfLine; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            logsWithDuration.putIfAbsent(user, 0);
            int totalDuration = logsWithDuration.get(user) + duration;
            logsWithDuration.put(user, totalDuration);

            logsWithIP.putIfAbsent(user, new TreeSet<>());
            logsWithIP.get(user).add(ip);

        }

        logsWithDuration.entrySet()
                .stream()
                .forEach(e -> {
                    String user = e.getKey();
                    int duration = e.getValue();
                    System.out.print(String.format("%s: %d",user, duration));
                    System.out.print(" " + "[");
                    int count = logsWithIP.get(e.getKey()).size();
                            for (String item : logsWithIP.get(e.getKey())) {
                                count --;
                                if (count > 0) {
                                    System.out.print(String.format("%s, ", item));
                                }else {
                                    System.out.print(item);
                                }
                    }
                    System.out.println("]");
                });

    }
}
