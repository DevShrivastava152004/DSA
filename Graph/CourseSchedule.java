import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
         // first we will create a adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
        graph.add(new ArrayList<>());
        }
        // then we will go over each prerequisites list and fill the map
        for(int[] p : prerequisites)
        {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }
        // then we will create the bfs queue from where we will pop out each of the element
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
            queue.offer(i);
        }
        // then the standard dfs pattern, we run a while loop until the queue is completely empty
        int completeCourses = 0;
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            completeCourses++;
            for(int nextCourse : graph.get(curr))
            {
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0)
                queue.offer(nextCourse);
            }
        }
        return completeCourses == numCourses;
    }
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        boolean canFinish = cs.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }
}
// the time complexity is O(V+ E) where V is the number of courses and E is the number of prerequisites. The space complexity is O(V+E) for storing the graph and indegree array.