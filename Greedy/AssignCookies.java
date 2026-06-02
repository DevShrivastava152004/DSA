import java.util.Arrays;

public class AssignCookies {
     public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int l=0,r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(l<m && r<n)
        {
            if(g[r] <= s[l])
            {
                r=r+1;
            }
            l=l+1;
        }
        return r;
        
    }
    public static void main(String[] args)
    {
        AssignCookies ac = new AssignCookies();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(ac.findContentChildren(g, s)); // Output: 1
    }
}
