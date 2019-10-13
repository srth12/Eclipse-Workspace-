package com.hackerrank.test.Zapr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given different boxes of candies and its prices, also the amount for which candies has to be brought,
 * find out the maximum number of candies that can be brought with the exact amount of money
 * 
 */
public class MaximumCandies {
    public static void main(String args[] ) throws Exception {
        // Scanner to get input
        Scanner scanner = new Scanner(System.in);

        // Getting amount
        Integer amount = 0;
        if(scanner.hasNextInt()){
            amount = scanner.nextInt();
        }

        // Getting number of boxes
        Integer numberOfBoxes = 0;
        if(scanner.hasNextInt()){
            numberOfBoxes = scanner.nextInt();
        }

        // Checking for invalid input
        if(amount <= 0 || numberOfBoxes <= 0){
            System.out.println("0");
            return;
        }

        // Variables for maintaining box quantities & prices
        Integer[] boxQuantities = new Integer[numberOfBoxes];
        Integer[] boxPrices = new Integer[numberOfBoxes];

        // Getting box Quantities
        if(scanner.hasNext()){
            String[] tempBoxQuantities = scanner.next().split(",");

            // Checking for invalid input
            if(tempBoxQuantities.length != numberOfBoxes){
                System.out.println("0");
                return;
            }

            for(int i=0; i < numberOfBoxes;i++){
                boxQuantities[i] = Integer.parseInt(tempBoxQuantities[i]);
            }
        }

        // Getting box Prices
        if(scanner.hasNext()){
            String[] tempBoxPrices = scanner.next().split(",");
            // Checking for invalid input
            if(tempBoxPrices.length != numberOfBoxes){
                System.out.println("0");
                return;
            }

            for(int i=0; i < numberOfBoxes;i++){
                boxPrices[i] = Integer.parseInt(tempBoxPrices[i]);
            }
        }

        // Calculating Max Quantity
        Integer maxQuantity = findMaxQuantity(amount, numberOfBoxes, boxQuantities, boxPrices);

        // Final Output
        System.out.println(maxQuantity);
    }

    private static Integer findMaxQuantity(Integer amount, Integer numberOfBoxes, Integer[] boxQuantities, Integer[] boxPrices){
        Integer maxQuantity;

        /******************* Add your logic here ***************/
        List<Integer> sortedList = getOrderedPriceIndexex(boxPrices);
        greedyAlgo(amount, sortedList, -1, boxQuantities, boxPrices);
        maxQuantity = totalCandy;
        return maxQuantity;
    }
private static int totalCandy = 0;
    public static void greedyAlgo(Integer amount, List<Integer> sortedPrice, int sortedCurrIndex, Integer[] boxQuantities, Integer[] boxPrices){
        if (amount == 0)
            return;
        if (amount % boxPrices[sortedPrice.get(++sortedCurrIndex)] == 0){
            int netQuantity = amount/boxPrices[sortedPrice.get(sortedCurrIndex)];
            totalCandy+= netQuantity;
            if (boxQuantities[sortedPrice.get(sortedCurrIndex)] >= netQuantity){
                amount = 0;
                return;
            }else {
                amount -= netQuantity *  boxPrices[sortedPrice.get(sortedCurrIndex)];
                greedyAlgo(amount, sortedPrice, sortedCurrIndex, boxQuantities, boxPrices);
            }
        } return;
    }

    public static List<Integer> getOrderedPriceIndexex(Integer[] boxPrices){
        Integer[] boxPricesCopy = boxPrices.clone();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(boxPricesCopy);
        for(int boxPrice: boxPricesCopy){
            int k = 0;
            while (boxPrice != boxPrices[k]){
                k++;
            }
            result.add(k);
        }
        return result;
    }
}
