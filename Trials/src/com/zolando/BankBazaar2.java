package com.zolando;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BankBazaar2 {

	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int n;
        n = Integer.parseInt(in.nextLine().trim());

        int p_size = 0;
        p_size = Integer.parseInt(in.nextLine().trim());

        int[] p = new int[p_size];
        for(int i = 0; i < p_size; i++) {
            int p_item;
            p_item = Integer.parseInt(in.nextLine().trim());
            p[i] = p_item;
        }

        res = getUmbrellas(n, p);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();}
	
	
	static int ans[] = new int[1001];
    /*
     * Complete the function below.
     */
    static int getUmbrellas(int n, int[] p) {
        if(n==0)
            return 0;
        if(ans[n] !=0)
            return ans[n];
        int minimum = -1;
        for(int i=0;i< p.length; i++){
            if(p[i]<=n){
                int val = getUmbrellas(n-p[i], p);
                if(val != -1){
                    if(minimum == -1){
                        minimum = val +1;
                    }else{
                        if(val+1 < minimum){
                            minimum =val +1;
                        }
                    }
                }
            }
        }
        ans[n]= minimum;
        return minimum;
    }

}
