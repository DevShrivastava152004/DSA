public class ConvertSortedArrayToBinarySearchTree {
    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }
    private TreeNode buildBST(int[] nums, int left, int right)
    {
        if(left > right)
        {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree converter = new ConvertSortedArrayToBinarySearchTree();
        int[] sortedArray = {-10, -3, 0, 5, 9};
        TreeNode bstRoot = converter.sortedArrayToBST(sortedArray);
        System.out.println("BST root value: " + bstRoot.val);
    }
} // the time complexity of this solution is O(n) where n is the number of elements in the input array, as we need to visit each element once to construct the BST. The space complexity is O(log n) on average for the recursive call stack, but in the worst case (when the tree is skewed), it can go up to O(n).