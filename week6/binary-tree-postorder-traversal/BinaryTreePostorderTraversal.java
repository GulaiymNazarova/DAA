import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverseTree(root, result);
        return result;
    }

    void traverseTree(TreeNode current, List<Integer> res) {
        if (current != null) {
            traverseTree(current.left, res);
            traverseTree(current.right, res);
            res.add(current.val);
        }
    }
}