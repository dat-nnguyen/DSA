package Graph;//package Graph;

import java.util.ArrayList;
import java.util.List;

public class TopoDFS {
    private int V;
    private List<List<Integer>> adj;
    boolean[] visited = new boolean[1001];
    private List<Integer> topo;

    public TopoDFS(int V){
        this.V = V;
        this.adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V + 1];
    }

    public void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void dfs(int start) {
        visited[start] = true;
        for(int v: adj.get(start)) {
            if(!visited[v]) dfs(v);
        }
        topo.add(start);
        //Collections.reverse(topo);
    }
    public static void main(String[] args) {
        TopoDFS g = new TopoDFS(8);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(1, 6);
        g.addEdge(7, 6);
        g.topo = new ArrayList<>();
        g.dfs(1);

        System.out.println(g.topo);
    }
}
