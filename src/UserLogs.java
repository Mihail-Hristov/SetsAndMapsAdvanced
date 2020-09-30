import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, Map<String, Integer>> userLogs = new TreeMap<>();

        while (!"end".equals(input)){
            String[] tokens = input.split("\\s+",3);
            String currentIpAddress = tokens[0].split("=")[1];
            String currentUserName = tokens[2].split("=")[1];

            userLogs.putIfAbsent(currentUserName, new LinkedHashMap<>());
            userLogs.get(currentUserName).putIfAbsent(currentIpAddress, 0);
            int countIp = userLogs.get(currentUserName).get(currentIpAddress) + 1;
            userLogs.get(currentUserName).put(currentIpAddress, countIp);

            input = scanner.nextLine();
        }

        userLogs.entrySet()
                .stream()
                .forEach(user -> {
                    String username = user.getKey();
                    System.out.println(String.format("%s:",username));

                    int countElements = user.getValue().size();

                    for (Map.Entry<String, Integer> ip: user.getValue().entrySet()){
                        countElements --;
                        if (countElements > 0){
                            System.out.print(String.format("%s => %d, ",ip.getKey(), ip.getValue()));
                        }else {
                            System.out.println(String.format("%s => %d.",ip.getKey(), ip.getValue()));
                        }
                    }
                });

    }
}
