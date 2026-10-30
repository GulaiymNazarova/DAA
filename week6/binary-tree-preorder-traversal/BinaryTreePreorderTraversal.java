import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        go(root, list);
        return list;
    }

    void go(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }
        l.add(node.val);
        go(node.left, l);
        go(node.right, l);
    }
}