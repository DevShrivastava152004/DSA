// we have to return all binary strings of length n that do not contain consecutive 1s
public class GenerateAllBinaryStrings {
    public static void generate(int n, String current, int prev)
    {
        //Base case
        if(n==0)
        {
            System.out.println(current);
            return;
        }
        generate(n-1, current+"0", 0);

        if(prev == 0)
        {
            generate(n-1, current+"1", 1);
        }
    }
    public static void main(String[] args) {
        int  n =3;
        generate(n,"", 0);
    }
}