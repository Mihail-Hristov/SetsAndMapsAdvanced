import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> miner = new LinkedHashMap<>();

        int count = 0;

        String previousString = "";

        while (!"stop".equals(input)){
            count ++;

            if (count % 2 != 0){
                miner.putIfAbsent(input, 0);

            }else {
                int quantity = miner.get(previousString) + Integer.parseInt(input);
                miner.put(previousString, quantity);
            }

            previousString = input;

            input = scanner.nextLine();
        }

        miner.entrySet()
                .stream()
                .forEach(m -> {
                    System.out.println(String.format("%s -> %d", m.getKey(), m.getValue()));
                });

    }
}
