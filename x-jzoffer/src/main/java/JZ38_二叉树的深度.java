/**
 * 题目描述 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。 示例1 输入 复制 {1,2,3,4,5,#,6,#,#,7} 返回值 复制 4
 * 
 * @author Yuqiu.He
 * @date 2021/3/15
 */
public class JZ38_二叉树的深度 {
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
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
