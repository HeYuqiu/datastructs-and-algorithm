import java.util.Arrays;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 输入 [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 *
 * 返回值 {1,2,5,3,4,6,7}
 * 
 * @author Yuqiu.He
 * @date 2021/1/19
 */
public class JZ4_重建二叉树 {
    // 思路：前序+中序可以唯一确定二叉树
    // 利用前序遍历的第一个节点确定中序遍历的中间节点，然后中序遍历以中间节点分隔成两部分，后面的继续递归下去
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode result = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                TreeNode treeNodeLeft
                    = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                TreeNode treeNodeRight = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                    Arrays.copyOfRange(in, i + 1, in.length));
                result.left = treeNodeLeft;
                result.right = treeNodeRight;
            }
        }
        return result;
    }

    // Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
