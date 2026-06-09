public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Agar land mila
                if (grid[i][j] == '1') {
                    islands++;          // Naya island
                    dfs(grid, i, j);    // Pure island ko mark kar do
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary check + water check
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            grid[row][col] == '0') {
            return;
        }

        // Visited mark kar diya
        grid[row][col] = '0';

        // 4 directions
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }
    public static void main(String[] args)
    {
         char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands obj = new NumberOfIslands();

        int result = obj.numIslands(grid);

        System.out.println("Number of Islands = " + result);
    }
}