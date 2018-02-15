package com.test;

public class ParseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String output = validate("|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n" );
		System.out.println(output);
	}
	
	static String validate(String input) {
		
		String[] lines = input.split("~n");
		
		String[] headers = lines[0].split("\\|");
		int noOfRecords = 0, noOfFields =0, noOfEmptyValues = 0;
		String nameOfLastField;
		
		noOfRecords = lines.length -1;
		String[] fields = lines[1].split("\\|");
		String[] line = lines[1].split("\\|");
		noOfFields = line.length;
		
		for(int i =0; i < noOfRecords; i++) {
			for( String field: lines[i].split("\\|")) {
				if(field.trim().equals(""))
					++noOfEmptyValues;
			}
		}
		
		int lastFieldSuffix = lines[1].split("\\|").length - headers.length;
		nameOfLastField = headers[headers.length -1] +"_" +lastFieldSuffix;
		return noOfRecords+":"+noOfFields+":"+noOfEmptyValues+":"+nameOfLastField;


    }

}
