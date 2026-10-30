import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        makePath(root, "", ans);
        return ans;
    }

    void makePath(TreeNode node, String currentPath, List<String> res) {
        if (node == null) {
            return;
        }

        currentPath = currentPath + node.val;

        if (node.left == null && node.right == null) {
            res.add(currentPath);
        } else {
            currentPath = currentPath + "->";
            makePath(node.left, currentPath, res);
            makePath(node.right, currentPath, res);
        }
    }
}