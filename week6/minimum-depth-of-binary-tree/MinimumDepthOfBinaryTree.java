public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // Если одна из веток пустая, нельзя брать 0 как минимум
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }

        if (leftDepth < rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }
}