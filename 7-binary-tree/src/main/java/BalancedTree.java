/**
 * 平衡二叉树
 * 
 * @author Yuqiu.He
 * @date 2021/3/15
 */
public class BalancedTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    /**
     * 返回一棵树是否是平衡二叉数，如果是返回数高，不是返回-1
     * 
     * @param root
     * @return
     */
    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        if (left == -1)
            return -1; // 如果发现发现子树不平衡就没有必要继续了
        int right = depth(root.right);
        if (right == -1)
            return -1; // 如果发现发现子树不平衡就没有必要继续了
        if (Math.abs(left - right) > 1)
            return -1;
        else
            return Math.max(left, right) + 1;
    }
}
