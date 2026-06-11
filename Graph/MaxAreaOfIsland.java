public class MaxAreaOfIsland
{
    private int dfs(int[][] grid,int i,int j)
    {
        if(i<0 || i >= grid.length || j<0 || j >= grid[i].length ||grid[i][j] == 0)
        {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid , i+1, j);
        area += dfs(grid,i-1,j);
        area += dfs(grid, i, j+1);
        area += dfs(grid, i, j-1);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid)
    {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int maxArea = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                int area = dfs(grid,i,j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        MaxAreaOfIsland maxi = new MaxAreaOfIsland();
        int[][] grid = {
    {0, 0, 1, 0, 0},
    {1, 1, 1, 0, 0},
    {0, 1, 0, 1, 1},
    {0, 0, 0, 1, 1}
};
        System.out.println("Largest Island Area = " + maxi.maxAreaOfIsland(grid));
    }
}
// the time complexity of this code is O(m*n) where m is the number of rows and n is the number of columns in the grid. This is because in the worst case, we may have to visit every cell in the grid once to calculate the area of each island. The space complexity is also O(m*n) in the worst case, due to the recursive call stack when we have a large island that occupies most of the grid.