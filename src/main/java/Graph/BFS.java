package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private int V;
    private List<List<Integer>> adj;
    boolean[] visited;

    public BFS(int V){
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

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int neighbour: adj.get(vertex)){
                if(!visited[neighbour]){
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
