public class PrintSubsequences
{
    public static void printSubSequence(String str, int index, String current)
    {
        if(index == str.length())
        {
            System.out.println(current);
            return;
        }
        // include the current character
        printSubSequence(str, index+1, current+str.charAt(index));
        // excluding the current character
        printSubSequence(str, index+1, current);
    }
    public static void main(String[] args) {
        String str = "abc";
        printSubSequence(str, 0, "");
    }
}
// The time complexity is O(2^n) and the space complexity is O(n) due to recursion stack space
