public class ValidParenthesis {
    public boolean isValid(String s)
    {
        int minOpen = 0;
        int maxOpen = 0;

        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                minOpen++;
                maxOpen++;
            }
            else if(c == ')')
            {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
            }
            else if(c == '*')
            {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen++;
            }

            if(maxOpen < 0)
            {
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        String s = "(*))";
        System.out.println(vp.isValid(s));
    }
}
// the time complexity of this solution is O(n) where n is the length of the input string, and the space complexity is O(1) since we are using a fixed amount of space to store the min and max open parentheses.