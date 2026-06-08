public class NumberOfProvinces {
    int n;
    private void dfs(int[][] isConnected, int city, boolean[] visited)
    {
        visited[city] = true;
        for(int neighbour = 0;neighbour < n;neighbour++)
        {
            if(isConnected[city][neighbour] == 1 && !visited[neighbour])
            {
                dfs(isConnected, neighbour, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected)
    {
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int city = 0;city<n;city++)
        {
            if(!visited[city])
            {
                provinces++;
                dfs(isConnected, city, visited);
            }
        }
        return provinces;
    }
    public static void main(String[] args) {
        NumberOfProvinces np = new NumberOfProvinces();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Number of Provinces = " + np.findCircleNum(isConnected)); // Output: 2
    }
}