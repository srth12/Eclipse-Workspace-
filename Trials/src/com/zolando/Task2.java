package com.zolando;
class Task2 {

	public int solution(int A, int B) {

		String firstNo = new Integer(A).toString();
		String secondNo = new Integer(B).toString();
		String result = "";
		while (!firstNo.equals("") && !secondNo.equals("")) {
			result = result.concat(getFirstNo(firstNo));
			firstNo = removeFirstNo(firstNo);

			result = result.concat(getFirstNo(secondNo));
			secondNo = removeFirstNo(secondNo);
		}

		if (!firstNo.equals(""))
			result = result.concat(firstNo);

		if (!secondNo.equals(""))
			result = result.concat(secondNo);

		return Integer.parseInt(result);
	}

	public String getFirstNo(String a) {
		return a.substring(0, 1);
	}

	public String removeFirstNo(String a) {
		if (a.length() != 1)
			return a.substring(1, a.length());
		else
			return "";
	}
}
