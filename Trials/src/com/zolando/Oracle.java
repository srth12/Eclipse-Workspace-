package com.zolando;

public class Oracle {

	public static void main(String[] args) {
		String res = parseJson("{ \"name\": \"Shri\", \"age\": 31, \"city\": \"London\", \"interests\":[\"Swimming\", \"Music\"]}   ");
		System.out.println(res);
	}
	/**
	 * { "name": "Shri", "age": 31, "city": "London", "interests":["Swimming", "Music"]}
	 * @param input
	 * @return
	 */
	
	public static String parseJson(String input) {
		boolean colunFound = false, valueFound = false, squareBracketFound = false;
		String resultParsed = "";
		boolean digitFound = false;
		for(char character : input.toCharArray()) {
			if(!colunFound && character != ':') {
				continue;
			}else if(!colunFound && character == ':') {
				colunFound = true;
				continue;
			}
			if(!squareBracketFound && character=='[') {
				squareBracketFound = true;
				continue;
			}
			if(squareBracketFound && character ==']') {
				squareBracketFound = false;
				colunFound = false;
				digitFound = false;
				continue;
			}
			if(valueFound && (character == '"')) {
				valueFound = false;
				if(!squareBracketFound) {
					colunFound = false;
				}
				continue;
			}
			if(valueFound) {
				resultParsed += character;
				continue;
			}
			if(digitFound && character ==',') {
				if(!squareBracketFound) {
					digitFound = false;
					colunFound = false;
				}else {
					resultParsed+=",";
				}
				
				continue;
			}
			if(digitFound) {
				resultParsed+=character;
			}
			if(!valueFound && (character == '"')) {
				valueFound = true;
				if(resultParsed.length() !=0) {
					resultParsed+=",";
				}
			}else if(!valueFound && !digitFound && (character != ' ' && character != '[') && character !=',') { //for digit scenarios
				digitFound = true;
				resultParsed+=","+character;
			}
			
		}
		
		return resultParsed;
	}

}
