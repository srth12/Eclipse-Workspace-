package com.hackerrank.code.graph.tree;

/**
 * Given N * M field of O's and X's, where O=white, X=black
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 */
public class CheckIfAdjacentNodesAreSameInColor {

    private static boolean[][] visited = new boolean[100][100];
    private static int count = 0;
    public static void main(String[] args) {
        int[][] inputs = {{'a', 'a', 'x'}, {'x','a','a'}, {'a','x','x'}};
        noOfBlackShapes(inputs);
        System.out.println(count);
    }

    public static int noOfBlackShapes(int[][] graph){
        int m = graph.length, n = graph[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 'x'){
                    count++;
                    dfs(graph, m, n, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] graph, int m, int n, int i, int j){
        if (i < m && j < n && graph[i][j] == 'x' && !visited[i][j]){
            visited[i][j] = true;
            dfs(graph, m, n, i+1, j);
            dfs(graph, m, n, i, j+1);
        }else return;
        return;
    }

}
