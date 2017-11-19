package com.test;

public class MatrixReach {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void traverse(int rowCount, int columnCount, int r, int c, int[][] a, Integer totalPaths) {
		if(r >= rowCount || c >= columnCount)
			return;
		if(r == rowCount -1 && c == columnCount -1) {
			totalPaths++;
			return;
		}
		traverse(rowCount, columnCount, r+1, c, a, totalPaths);
		traverse(rowCount, columnCount, r, c+1, a, totalPaths);
		
	}
	
	static int numberOfPaths(int[][] a) {
		Integer totalPaths =0;
		int rowCount = a.length;
		int columnCount = a[0].length;
		traverse(rowCount, columnCount, 0, 0, a, totalPaths);
		return totalPaths;
	}

}
