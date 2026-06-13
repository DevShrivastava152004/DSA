import java.util.*;
public class DetectCycleUndirectedGraph
{
    private boolean isCycleUtil(ArrayList<Integer>[] graph, int node, boolean[] visited, int parent)
    {
        visited[node] = true;
        for(int neighbor : graph[node])
        {
            if(neighbor == parent)
            {
                continue;
            }
            if(visited[neighbor])
            {
                return true;
            }
            if(isCycleUtil(graph, neighbor, visited, node))
            {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges)
    {
        ArrayList<Integer>[] graph = new ArrayList[V];

        for(int i=0;i<V;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(isCycleUtil(graph, i, visited, -1))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        DetectCycleUndirectedGraph dcug = new DetectCycleUndirectedGraph();
        int V = 5;
        int[][] edges = {{0,1}, {1,2}, {2,0}, {1,3}, {3,4}};
        boolean hasCycle = dcug.isCycle(V, edges);
        System.out.println("Does the graph contain a cycle? " + hasCycle);
    }
}