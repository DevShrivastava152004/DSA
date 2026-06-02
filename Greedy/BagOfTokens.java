import java.util.Arrays;
import java.util.Scanner;

public class BagOfTokens
{
    public int bagOfTokensScore(int[] tokens, int power)
    {
        int n = tokens.length;

        // Sort tokens
        Arrays.sort(tokens);

        int currScore = 0;
        int maxScore = 0;

        int l = 0;
        int r = n - 1;

        while(l <= r)
        {
            // Play face up
            if(power >= tokens[l])
            {
                power -= tokens[l];
                currScore++;

                maxScore = Math.max(maxScore, currScore);

                l++;
            }

            // Play face down
            else if(currScore >= 1)
            {
                power += tokens[r];
                currScore--;

                r--;
            }

            // Cannot make any move
            else
            {
                return maxScore;
            }
        }

        return maxScore;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter number of tokens: ");
        int n = sc.nextInt();

        int[] tokens = new int[n];

        // Input tokens
        System.out.println("Enter token values:");

        for(int i = 0; i < n; i++)
        {
            tokens[i] = sc.nextInt();
        }

        // Input power
        System.out.print("Enter initial power: ");
        int power = sc.nextInt();

        // Create object
        BagOfTokens obj = new BagOfTokens();

        // Call method
        int result = obj.bagOfTokensScore(tokens, power);

        // Print answer
        System.out.println("Maximum Score = " + result);

        sc.close();
    }
}