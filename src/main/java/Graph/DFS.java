//package Graph;

import java.util.ArrayList;
import java.util.List;


public class DFS {
    private int V;
    private List<List<Integer>> adj;
    boolean[] visited;

    public DFS(int V){
        this.V = V;
        this.adj = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void dfs(int u) {
        System.out.println(u + " "); // visit vertex

        visited[u] = true;
        for(int v: adj.get(u)) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
    public void startDFS(int startIndex){
        // reset boolean
        this.visited = new boolean[V + 1];

        System.out.println("DFS traversal from vertex " + startIndex);
        dfs(startIndex);
        System.out.println();
    }
    public static void main(String[] args) {
        DFS graph = new DFS(8);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        graph.startDFS(5);

    }
}
