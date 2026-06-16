import java.util.*;

public class TopologicalSort {

    // DFS function
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node,
                     boolean[] visited, Stack<Integer> stack) {

        // Mark current node as visited
        visited[node] = true;

        // First visit all neighbours
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited, stack);
            }
        }

        // Push current node after visiting all neighbours
        stack.push(node);
    }

    // Function to return Topological Sort
    public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Run DFS for every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        // Store topological order
        ArrayList<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
    public static void main(String[] args) {
        TopologicalSort solution = new TopologicalSort();
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example directed graph edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> topologicalOrder = solution.topoSort(V, adj);
        System.out.println("Topological Sort: " + topologicalOrder);
    }
} // the time complexity of this solution is O(V + E), where V is the number of vertices and E is the number of edges in the graph. The space complexity is O(V) for the visited array and the stack used to store the topological order.