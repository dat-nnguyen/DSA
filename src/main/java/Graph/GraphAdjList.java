// package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphAdjList {
    private List<List<Integer>> adj;
    private int V;

    public GraphAdjList(int V) {
        this.V = V;

        this.adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void printGraph() {
        System.out.println("This is graph adjacency list: ");
        // Duyệt từ 1 đến V
        for (int i = 1; i <= V; i++) {
            System.out.print(i + " -> ");
            // In danh sách kề của đỉnh i
            for (int neighbor : adj.get(i)) {

                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println();

        GraphAdjList graph = new GraphAdjList(V);
        System.out.println("Enter edges: ");

        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.adj.get(x).add(y);
            graph.adj.get(y).add(x); // có hướng thì bỏ dòng này
        }

        graph.printGraph();
    }
}