import java.util.*;
public class RatInaMaze {

    ArrayList<String> result = new ArrayList<>();
    private void solve(int i,int j, int[][] maze, int n, StringBuilder path)
    {
        
        if(i<0 || j >=n || j <0 || i >=n || maze[i][j] == 0)
        {
            return;
        }
        if(i == n-1 && j == n-1)
        {
            result.add(path.toString());
            return;
        }
        maze[i][j] = 0;
        
        path.append('D');
        solve(i+1,j,maze,n, path);
        path.deleteCharAt(path.length() - 1);

        path.append('L');
        solve(i,j-1,maze,n,path);
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        solve(i,j+1,maze,n,path);
        path.deleteCharAt(path.length() - 1);

        path.append('U');
        solve(i-1,j,maze,n,path);
        path.deleteCharAt(path.length() - 1);

        maze[i][j] = 1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        if(maze[0][0] == 0)
            return result;
        
        solve(0,0,maze,n,new StringBuilder());

        return result;
    }

    public static void main(String[] args) {
        int[][] maze = {
             {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        RatInaMaze obj = new RatInaMaze();
        ArrayList<String> paths = obj.ratInMaze(maze);

        if(paths.size() == 0)
        {
            System.out.println("No path found");
        }
        else{
            for(String path : paths)
            {
                System.out.println(path);
            }
        }
    }
}