public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                return true;
            }
        }

        boolean checkLeft = hasPathSum(root.left, targetSum - root.val);
        boolean checkRight = hasPathSum(root.right, targetSum - root.val);

        if (checkLeft == true || checkRight == true) {
            return true;
        }
        return false;
    }
}