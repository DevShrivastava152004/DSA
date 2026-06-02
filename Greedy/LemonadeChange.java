public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        // Count of $5 bills
        int five = 0;

        // Count of $10 bills
        int ten = 0;

        // Traverse each customer's bill
        for (int bill : bills) {

            // Customer gives $5
            // No change needed
            if (bill == 5) {
                five++;
            }

            // Customer gives $10
            // Need to return one $5
            else if (bill == 10) {

                // If we have a $5 bill
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }

            // Customer gives $20
            else {

                // Best strategy:
                // Give one $10 and one $5 first
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }

                // Otherwise give three $5 bills
                else if (five >= 3) {
                    five -= 3;
                }

                // Cannot provide change
                else {
                    return false;
                }
            }
        }

        // Successfully gave change to everyone
        return true;
    }
    public static void main(String[] args) {
        LemonadeChange solution = new LemonadeChange();
        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};

        System.out.println(solution.lemonadeChange(bills1)); // Output: true
        System.out.println(solution.lemonadeChange(bills2)); // Output: false
    }
}// Time Complexity: O(n), where n is the number of customers (length of the bills array).
// Space Complexity: O(1), since we are using only a constant amount of extra space
