class FibonacciNumber 
{
    static int f(int n)
    {
        if(n <= 1)
            return n;

        int last = f(n-1);
        int slast = f(n-2);

        return last + slast;
}
public static void main(String[] args) {
    int n = 4;
    int result = f(n);
    System.out.println(result);
}
}