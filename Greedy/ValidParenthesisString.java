public class ValidParenthesisString {
    public boolean checkValidString(String s)
    {
        int min = 0;
        int max = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                min++;
                max++;
            }
            else if(c == ')')
            {
                min--;
                max--;
            }
            else {
                min--;
                max++;
            }
            if(max < 0)
                return false;
            if(min < 0)
                min = 0;
        }
        return min == 0;
    }
    public static void main(String[] args)
    {
        ValidParenthesisString solution  = new ValidParenthesisString();
        String s = "(*))";
        boolean result = solution.checkValidString(s);
        System.out.println(result); // true

    }
}