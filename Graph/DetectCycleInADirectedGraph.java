import java.util.*;
public class DetectCycleInADirectedGraph {
    private boolean isCycle(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion)
    {
        visited[u] = true;
        inRecursion[u] = true;

        for(int v : adj.get(u))
        {
            if(!visited[v] && isCycle(adj, v, visited, inRecursion))
            {
                return true;
            }
            else if(inRecursion[v])
            {
                return true;
            }
        }
        inRecursion[u] =false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i] && isCycle(adj,i,visited,inRecursion))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        DetectCycleInADirectedGraph graph = new DetectCycleInADirectedGraph();
        int V = 4;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        boolean hasCycle = graph.isCyclic(V, edges);
        System.out.println("Does the directed graph have a cycle? " + hasCycle);
    }
}