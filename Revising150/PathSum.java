class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // If leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}

public class PathSum {
    public static void main(String[] args) {

        /*
                  5
                 / \
                4   8
               /   / \
              11 13   4
             / \       \
            7   2       1

            Target Sum = 22
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        Solution sol = new Solution();

        boolean result = sol.hasPathSum(root, targetSum);

        System.out.println("Path Exists: " + result);
    }
}