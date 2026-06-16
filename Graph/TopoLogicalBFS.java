import java.util.*;
public class TopoLogicalBFS {
    public static ArrayList<Integer> topoSort(int V,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[V];
        
        for(int node =0 ;node < V;node++)
        {
            for(int neighbour : adj.get(node))
            {
                indegree[neighbour]++;
            }
        }
        for(int node = 0;node<V;node++)
        {
            if(indegree[node] == 0)
            {
                queue.offer(node);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            result.add(current);
            
            for(int neighbour : adj.get(current))
            {
                indegree[neighbour]--;
                
                if(indegree[neighbour] == 0)
                {
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }
    // function to add directed edge
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u,int v)
    {
        adj.get(u).add(v);
    }
    public static void main(String[] args)
    {
        int V = 6;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,5,2);
        addEdge(adj,5,0);
        addEdge(adj,4,0);
        addEdge(adj,4,1);
        addEdge(adj,2,3);
        addEdge(adj,3,1);
        
        ArrayList<Integer> topoOrder = topoSort(V,adj);
        
        // Print result
        System.out.println("Topological order ");
        
        for(int node : topoOrder)
        {
            System.out.println(node + " ");
        }
    }
} // the time complexity of this solution is O(V + E), where V is the number of vertices and E is the number of edges in the graph. The space complexity is O(V) for the indegree array and the queue used to store nodes with zero indegree.