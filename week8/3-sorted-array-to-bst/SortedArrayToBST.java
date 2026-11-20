public class SortedArrayToBST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    static TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }

    static void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        printPreorder(root);
    }
}
