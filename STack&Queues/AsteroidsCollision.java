import java.util.*;

public class AsteroidsCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids)
        {
            if(asteroid > 0)
            {
                st.push(asteroid);
            }
            else
            {
                while(!st.isEmpty() &&
                      st.peek() > 0 &&
                      st.peek() < Math.abs(asteroid))
                {
                    st.pop();
                }

                if(!st.isEmpty() &&
                   st.peek() == Math.abs(asteroid))
                {
                    st.pop();
                }
                else if(st.isEmpty() || st.peek() < 0)
                {
                    st.push(asteroid);
                }
            }
        }

        int[] result = new int[st.size()];

        for(int i = 0; i < st.size(); i++)
        {
            result[i] = st.get(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 20, -10};

        AsteroidsCollision sol = new AsteroidsCollision();

        int[] ans = sol.asteroidCollision(arr);

        System.out.println("The state of asteroids after all collisions:");

        for(int i = 0; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
}