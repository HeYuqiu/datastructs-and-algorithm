import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 题目描述 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 示例1 输入 {10,5,12,4,7},22
 *
 * 返回值 [[10,5,7],[10,12]]
 *
 * 示例2 输入 {10,5,12,4,7},15
 *
 * 返回值 []
 * 
 * @author Yuqiu.He
 * @date 2021/2/2
 */
public class JZ24_二叉树中和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        find(root, target, new ArrayList<>());
        return result;
    }

    public void find(TreeNode root, int target, ArrayList<Integer> nowList) {

        if (root.left == null && root.right == null) {
            // 到叶子节点了
            nowList.add(root.val);
            AtomicInteger total = new AtomicInteger(0);
            nowList.forEach(item -> total.set(total.get() + item));
            if (target == total.get()) {
                result.add(nowList);
            }
        } else {
            ArrayList<Integer> left = new ArrayList<>(nowList);
            ArrayList<Integer> right = new ArrayList<>(nowList);
            if (root.left != null) {
                find(root.left, target, left);
            }
            if (root.right != null) {
                find(root.right, target, right);
            }
        }
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
