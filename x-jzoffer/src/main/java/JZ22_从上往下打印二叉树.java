import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 示例1 输入 {5,4,#,3,#,2,#,1}
 *
 * 返回值 [5,4,3,2,1]
 * 
 * @author Yuqiu.He
 * @date 2021/2/2
 */
public class JZ22_从上往下打印二叉树 {

    // 思路：队列，（不能用前序遍历）
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left != null)
                queue.offer(poll.left);
            if (poll.right != null)
                queue.offer(poll.right);
        }
        return result;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
