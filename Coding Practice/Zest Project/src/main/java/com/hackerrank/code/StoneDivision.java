package com.hackerrank.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

enum PLAYERS{
    FIRST,SECOND
}

public class StoneDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        List<Long> inputs = new ArrayList<>();
        for (int i=0;i < m; i++){
            inputs.add(scanner.nextLong());
        }
        System.out.println(getTheWinner(inputs, n));
    }

    public static String getTheWinner(List<Long> pileOptions, long n){
        List<Long> availablePileList = new ArrayList<Long>();
        boolean isPlayerOneTurn = true;
        pileOptions = pileOptions.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        availablePileList.add(n);
        while (availablePileList.size() != 0){
            for (long pileOption : pileOptions){
                for (long pile : availablePileList){
                    if (pile % pileOption != 0){
                        //
                    }else {
                        availablePileList.remove(pile);
                        addGivenPilesToTheList(availablePileList, pile, pile / pileOption);
                        isPlayerOneTurn = !isPlayerOneTurn;
                    }
                }
            }
        }

        printAvailablePileSize(availablePileList);
        if (isPlayerOneTurn)
            return PLAYERS.FIRST.name();
        else  return PLAYERS.SECOND.name();
    }

    private static void printAvailablePileSize(List<Long> availablePileList) {
//        availablePileList.forEach(System.out::println);

//        availablePileList.forEach(x -> printerC.accept("Data "+ x));
    }

//    private  static Consumer<String> printerC = x -> System.out.println(x);

    private static void addGivenPilesToTheList(List<Long> pileList, long pile, long times) {
        for (long i = 0; i< times; i++){
            pileList.add(pile);
        }
    }
}
