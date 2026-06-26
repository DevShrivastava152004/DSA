import java.util.*;
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        // Indegree Array
        int[] indegree = new int[numCourses];

        // Build Graph
        for(int[] pre : prerequisites)
        {
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // And all nodes having indegree 0
        for(int  i=0;i<numCourses;i++)
        {
            if(indegree[i]  == 0)
            {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty())
        {
            int current = queue.poll();
            order[index++] = current;

            for(int neighbor : adj.get(current))
            {
                indegree[neighbor]--;

                if(indegree[neighbor] == 0)
                {
                    queue.offer(neighbor);
                }
            }
        }
        if(index != numCourses)
        {
            return new int[0];
        }
        return order;
    }
    public static void main(String[] args) {
        CourseSchedule2 cs2 = new CourseSchedule2();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] order = cs2.findOrder(numCourses, prerequisites);
        if(order.length == 0)
        {
            System.out.println("No valid order exists.");
        } else {
            System.out.print("Valid order to finish courses: ");
            for(int course : order) {
                System.out.print(course + " ");
            }
            System.out.println();
        }
    }
}