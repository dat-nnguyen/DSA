package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixToEdgeList {
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

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V + 1][V + 1];
        System.out.println("Enter matrix: ");
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        List<Edge> adjList = new ArrayList<>();
        for(int i = 1; i <= V; i++) {
            for(int j = 1; j <= V; j++) {
                if(graph[i][j] == 1) {
                    adjList.add(new Edge(i, j));
                }
            }
        }
        System.out.println("This is graph edge list: ");
        for(Edge e: adjList) {
            System.out.println(e.start + " " + e.end);
        }
    }
}
