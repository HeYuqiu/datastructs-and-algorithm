import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 
 * @author Yuqiu.He
 * @date 2021/2/4
 */
public class JZ26_二叉搜索树与双向链表 {
    private List<TreeNode> sortResult = new ArrayList<>();

    // 思路：先中序遍历排好序，然后再设置指针
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        midTaverse(pRootOfTree);
        TreeNode pre = sortResult.get(0);
        pre.left = null;
        for (int i = 1; i < sortResult.size(); i++) {
            pre.right = sortResult.get(i);
            sortResult.get(i).left = pre;
            pre = sortResult.get(i);
        }
        sortResult.get(sortResult.size() - 1).right = null;
        return sortResult.get(0);
    }

    public void midTaverse(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            midTaverse(pRootOfTree.left);
            sortResult.add(pRootOfTree);
            midTaverse(pRootOfTree.right);
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
