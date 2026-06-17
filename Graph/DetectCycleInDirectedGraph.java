import java.util.*;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[V];
        
        // Calculate indegree of each node
        for(int i=0;i<V;i++)
        {
            for(int neighbor : adj.get(i))
            {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<V;i++)
        {
            if(indegree[i] == 0)
            {
                queue.offer(i);
            }
        }
        int count = 0;
        
        // BFS
        while(!queue.isEmpty())
        {
            int node = queue.poll();
            count++;
            
            for(int neighbor : adj.get(node))
            {
                indegree[neighbor]--;
                
                if(indegree[neighbor] == 0)
                {
                    queue.offer(neighbor);//queue.offer helps in inserting a specified element in the queue
                }
            }
        }
        // if all nodes are processed ==> No Cycle
        return count !=V;
    }
    public static void main(String[] args)
    {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        
        {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
        
        if(obj.isCyclic(V, adj))
        {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No Cycle");
        }
        
    }
    
}