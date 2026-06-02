public class LengthOfLastWord 
{
    public int lengthOfLastWord(String s)
    {
        s = s.trim();
        int count = 0;
        for(int i = s.length() - 1;i >= 0; i--)
        {
            if(s.charAt(i) == ' ')
            {
                count++;
            }
            else 
            {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        LengthOfLastWord obj = new LengthOfLastWord();

        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";

        System.out.println(obj.lengthOfLastWord(s1)); // Output: 5
        System.out.println(obj.lengthOfLastWord(s2)); // Output: 4
        System.out.println(obj.lengthOfLastWord(s3)); // Output: 6

    }
}