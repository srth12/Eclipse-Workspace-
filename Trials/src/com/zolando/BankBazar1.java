package com.zolando;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BankBazar1 {

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

        long res;
        int binary_size = 0;

        LinkedListNode binary = null;
        LinkedListNode binary_tail = null;

        binary_size = Integer.parseInt(in.nextLine());

        for(int i = 0; i < binary_size; i++) {
            int binary_item;
            binary_item = Integer.parseInt(in.nextLine().trim());
            binary_tail = _insert_node_into_singlylinkedlist(binary, binary_tail, binary_item);

            if(i == 0) {
                binary = binary_tail;
            }
        }


        res = getNumber(binary);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

	 public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val) {
	        if(head == null) {
	            head = new LinkedListNode(val);
	            tail = head;
	        }
	        else {
	            tail.next = new LinkedListNode(val);
	            tail = tail.next;
	        }
	        return tail;
	    }
	 
	 public static class LinkedListNode {
	        int val;
	        LinkedListNode next;

	        LinkedListNode(int node_value) {
	            val = node_value;
	            next = null;
	        }
	    };
	    
	    static long getNumber(LinkedListNode binary) {
	    		if(binary == null)
	    			return 0;
	    		StringBuilder binaryString =new StringBuilder("");
	    		
	    		while(binary != null) {
	    			binaryString.append(binary.val);
	    			binary = binary.next;
	    		}
	    		int length = binaryString.toString().trim().length();
	    		
	    		long result = 0;
	    		for(int i=binaryString.length() -1;i>=0 ; i--) {
	    			int power = length - i - 1;
	    			int val = binaryString.charAt(i)=='0'?0:1;
	    			result = (long) (result + Math.pow(2, power )*val);
	    		}
	    	
			return result;
	        
	    }

}
