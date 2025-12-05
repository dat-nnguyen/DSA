package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixToAdjList {
    private List<List<Integer>> adj = new ArrayList<>();

    static class Edge {
        int start;
        int end;


        public Edge(int s, int e){
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V + 1][V + 1];
        System.out.println("Enter matrix: ");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }


    }
}
