/**
 * 题目描述 输入一棵二叉树，判断该二叉树是否是平衡二叉树。 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树 平衡二叉树（Balanced Binary
 * Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。 示例1 输入 复制 {1,2,3,4,5,6,7} 返回值 复制 true
 * 
 * @author Yuqiu.He
 * @date 2021/3/15
 */
public class JZ39_平衡二叉树 {
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

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
