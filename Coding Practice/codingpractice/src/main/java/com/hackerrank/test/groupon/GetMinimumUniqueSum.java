package com.hackerrank.test.groupon;

import java.util.Arrays;

public class GetMinimumUniqueSum {

    // Complete the getMinimumUniqueSum function below.

    public static void main(String[] args) {
        int res = getMinimumUniqueSum(new int[]{1,1,1});
        System.out.println(res);
    }
    static int getMinimumUniqueSum(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length -1; i++) {
                if (arr[i] >= arr[i+1])
                    arr[i+1] = arr[i] + 1;
        }
        return Arrays.stream(arr).sum();
    }
}
