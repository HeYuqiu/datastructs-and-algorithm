/**
 * 二叉树遍历
 * @author Yuqiu.He
 * @date 2020-07-16
 */
public class TraverseTree {

    /**
     * 前序遍历
     *
     * @param treeNode
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        System.out.println(treeNode.value);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        inOrder(treeNode.left);
        System.out.println(treeNode.value);
        inOrder(treeNode.right);
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public void postOrder(TreeNode treeNode) {
        if (treeNode == null)
            return;
        inOrder(treeNode.left);
        inOrder(treeNode.right);
        System.out.println(treeNode.value);
    }
}
