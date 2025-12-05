package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponent {
// number of connected components == number of dfs or bfs call
    private int V;
    private List<List<Integer>> adj;
    boolean[] visited;

    public ConnectedComponent(int V){
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

    public void dfs(int u){
        System.out.println(u + " ");
        visited[u] = true;
        for(int v: adj.get(u)){
            if(!visited[v]) dfs(v);
        }
    }
    public int countComponents(){
        int count = 0;

        for(int i = 1; i <= V; i++){
            if(!visited[i]){
                ++count;
                System.out.println("Vertices of component " + count + ": ");
                dfs(i);

            }
        }

        return count;
    }
}
