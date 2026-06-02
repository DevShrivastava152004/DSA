class Solution {
    public String removeOuterParenthesis(String s)
    {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == ')')
            {
                cnt--;
            }
            if(cnt != 0)
            {
                ans.append(s.charAt(i));
            }
            if(s.charAt(i) == '(')
            {
                cnt++;
            }
        }
        return ans.toString();
    }
}
public class Parenthesis
{
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "(()())(())";
        String result = sol.removeOuterParenthesis(s);
        System.out.println("Outer Parenthesis " + result);
    }
}