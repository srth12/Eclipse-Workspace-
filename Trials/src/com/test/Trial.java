package com.test;

import java.util.Arrays;

public class Trial {
 int b;
	class Inner{
		void test() {
			if(Trial.this.flag) {
				sample();
			}
		}
	}
	private boolean flag = true;
	public void sample() {
		System.out.println("Sample");
	}
	public Trial() {
		
		(new Inner()).test();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		/*do {
			i++;
		}while(i<0);
		System.out.println(i);*/
		/*new Trial();
		double d = -10.0 / 0;
		if(d == Double.NEGATIVE_INFINITY)
			System.out.println("negativve");6
		if(d == Double.POSITIVE_INFINITY)
			System.out.println("positive");*/
		int[] a = new int[] {1,1,1,1};
		System.out.println(maxDifference(a));

	}
	
	static int maxDifference(int[] a) {
        int minElement = Integer.MAX_VALUE;
        if(a.length==1)
            return -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; (i< a.length && (a[i] == Integer.MAX_VALUE || a[i] < minElement)); i++){
            for(int j=i+1; j< a.length-1;j++){
                max = a[j]-a[i] > max? a[j]-a[i]: max;
            }
            minElement = a[i] < minElement? a[i]: minElement;
        }
        if(max == Integer.MIN_VALUE)
            return -1;
        return max;
    }
	
	static String mergeStrings(String a, String b) {
        StringBuilder result = new StringBuilder("");
        boolean aIsMax = false, bIsMax = false;
        int min = 0;
        if( a.length() > b.length()){
            if(b.length()==0)
                return a;
            min = b.length();
            aIsMax = true;
        }else if( a.length() < b.length()){
            if(a.length()==0)
                return b;
            min = a.length();
            bIsMax = true;
        }else
            return "";
        
        for(int i = 0; i< min; i++){
            result.append(a.charAt(i)).append(b.charAt(i));
        }
        
        if(aIsMax)
            result.append(a.subSequence(min, a.length()));
        else result.append(b.subSequence(min, b.length()));
        
        return result.toString();

    }

}
