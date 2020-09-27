import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0){

            int firstPlayerCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard){
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            }else if(firstPlayerCard < secondPlayerCard){
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }

            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
        }


        if (firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        }else if(firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
