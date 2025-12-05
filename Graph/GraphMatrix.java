package Graph;//package Graph;

import java.util.Scanner;

public class GraphMatrix {

    private int V; // Vertices
    private int[][] matrix;

    public GraphMatrix(int V){
        this.V = V;
        this.matrix = new int[1001][1001];
    }

    public void printGraph(){
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.println();

        GraphMatrix graph = new GraphMatrix(V);
        System.out.println("Enter edges: ");
        for(int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph.matrix[x][y] = 1;
            graph.matrix[y][x] = 1;
        }
        System.out.println("This is the graph: ");
        graph.printGraph();
    }
}
