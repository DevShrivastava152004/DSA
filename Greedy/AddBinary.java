public class AddBinary {
    public static String addbinary(String a,String b)
    {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() -1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry == 1)
        {
            int sum = carry;
            if(i >= 0)
            {
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0)
            {
                sum += b.charAt(j) - '0';
                j--;    
            }
            result.append(sum % 2);
            carry = sum /2 ;
        }
        return result.reverse().toString();
    }
    public static void main(String[] args)
    {
        String a1 = "11";
        String b1 = "1";

        System.out.println("Output: " + addbinary(a1, b1));

        String a2 = "1010";
        String b2 = "1011";

        System.out.println("Output: " + addbinary(a2,b2));
    }
    
}
