import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    void helper(TreeNode n, List<Integer> arr) {
        if (n == null) {
            return;
        }
        helper(n.left, arr);
        arr.add(n.val);
        helper(n.right, arr);
    }
}