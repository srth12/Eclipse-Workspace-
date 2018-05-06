package com.hackerrank.test.crossover;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ColumnNameLikeSpreadSheet {

    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this function!
     */
    static List<String> columnNames(int n)
    {

        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Function<Integer, String> excelColumn = columnNumber -> {
            int base = 26;
            String columnName = "";

            while (columnNumber > 0) {
                int position = columnNumber % base;
                columnName = (position == 0 ? 'Z' : alphabets.charAt(position > 0 ? position - 1 : 0)) + columnName;
                columnNumber = (columnNumber - 1) / base;
            }
            return columnName;
        };

        List<String> result = new ArrayList<String>();

        result = IntStream.range(1, n+1).mapToObj(x -> excelColumn.apply(x)).collect(Collectors.toList());

        return result;
    }


    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);

        int _columns = Integer.parseInt(in.nextLine().trim());

        List<String> result = columnNames(_columns);

        System.out.println(String.join(", ", result));
    }
}
