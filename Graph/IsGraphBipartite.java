import java.util.Arrays;

public class IsGraphBipartite {

    public boolean dfs(int[][] graph, int node, int[] color, int currentColor) {

        color[node] = currentColor;

        for (int neighbor : graph[node]) {

            if (color[neighbor] == -1) {

                if (!dfs(graph, neighbor, color, 1 - currentColor)) {
                    return false;
                }

            } else if (color[neighbor] == currentColor) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!dfs(graph, i, color, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        IsGraphBipartite obj = new IsGraphBipartite();

        // Example 1 (Bipartite)
        int[][] graph1 = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        // Example 2 (Not Bipartite)
        int[][] graph2 = {
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };

        System.out.println("Graph 1 is Bipartite: " + obj.isBipartite(graph1));
        System.out.println("Graph 2 is Bipartite: " + obj.isBipartite(graph2));
    }
} // the time complexity of this code is O(V + E), where V is the number of vertices (nodes) and E is the number of edges in the graph. This is because we perform a depth-first search (DFS) traversal of the graph, visiting each vertex and edge once. The space complexity is O(V) due to the color array used to keep track of the colors assigned to each vertex.