package com.hackerrank.test.healthify;


public class NextNonDecendingNumber {

    public static void main(String[] args) {

        System.out.println(getNextNonDecendingNumber(11));
    }

    public static int getNextNonDecendingNumber(int number){
        char[] numberInArray = (number+"").toCharArray();
        int resetFromIndex = -1;
        int index = numberInArray.length - 1;
        for (int i = index; i > 0 ; i--) {
            if (numberInArray[i -1] >= numberInArray[i]){
                resetFromIndex = i - 1;
            }
        }

        if (resetFromIndex != -1) {
            numberInArray[resetFromIndex]--;

            for (int i = resetFromIndex + 1; i < numberInArray.length; i++) {
                numberInArray[i] = '9';
            }
        }else {
            --numberInArray[numberInArray.length -1];
        }
        String tempResult = "";
        for (int i = 0; i < numberInArray.length; i++) {
            tempResult += numberInArray[i];
        }
        return Integer.valueOf(tempResult);
    }
}
