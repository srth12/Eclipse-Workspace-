package com.hackerrank.code;

import java.util.*;
import java.util.stream.Collectors;

enum PLAYERS {
    FIRST("First"), SECOND("Second");

    public String getValue() {
        return value;
    }

    private final String value;

    PLAYERS(String value) {
        this.value = value;
    }
}

/**
 * Let  be Grundy function of the game with a single pile with  stones. After splitting  into  piles of size ,
 * we have  independent games with  stones. Thus, our resulting Grundy function after turn will be  ( times).
 * This is equal to  if  is odd and  if  is even.
 * <p>
 * If at the beginning of the game the first player can split a pile into even number of piles, this player wins,
 * as the Grundy function of the game becomes equal to . Otherwise, during all the game all splits will be on even number of piles.
 * As the Grundy function changes from  to  we can replace our game after each turn with the game with one pile.
 * As there are only  divisors of , we can calculate for each divisor if it is winning position or not.
 * The total time complexity will be  ( arises here because we have to store answers for each divisor in dictionary/map).
 */
public class StoneDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        List<Long> inputs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            inputs.add(scanner.nextLong());
        }
        System.out.println(getTheWinner(inputs, n));
    }

    public static String getTheWinner(List<Long> pileOptions, long n) {
        List<Long> availablePileList = new ArrayList<Long>();
        boolean isPlayerOneTurn = true;
        pileOptions = pileOptions.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        availablePileList.add(n);
        boolean isModifiedPile = true;
        while (availablePileList.size() != 0 && isModifiedPile) {
            isModifiedPile = false;
            for (int k = 0; k < pileOptions.size() && !isModifiedPile; k++) {
                long pileOption = pileOptions.get(k);
                for (ListIterator<Long> itr = availablePileList.listIterator(); itr.hasNext(); ) {
                    Long pile = itr.next();
                    if (pile % pileOption != 0) {
                        //
                    } else {
                        itr.remove();
                        addGivenPilesToTheList(itr, pileOption, pile / pileOption);
                        isPlayerOneTurn = !isPlayerOneTurn;
                        isModifiedPile = true;
                        break;
                    }
                }
            }
        }

        printAvailablePileSize(availablePileList);
        if (isPlayerOneTurn)
            return PLAYERS.SECOND.getValue();
        else return PLAYERS.FIRST.getValue();
    }

    private static void printAvailablePileSize(List<Long> availablePileList) {
//        availablePileList.forEach(System.out::println);

//        availablePileList.forEach(x -> printerC.accept("Data "+ x));
    }

//    private  static Consumer<String> printerC = x -> System.out.println(x);

    private static void addGivenPilesToTheList(ListIterator<Long> pileListIterator, long times, long pile) {
        if (pile == 1)
            return;
        for (long i = 0; i < times; i++) {
            pileListIterator.add(pile);
        }
    }
}
