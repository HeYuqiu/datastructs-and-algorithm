/**
 * 二叉查找树的查找、插入、删除操作
 *
 * @author Yuqiu.He
 * @date 2020-07-30
 */
public class BinarySearchTree {
    // 查找测试
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();

//        TreeNode result = search(treeNode, 30);
//        TreeNode result1 = searchWithCycle(treeNode, 30);
//        TreeNode result2 = search(treeNode, 11);
//        System.out.println(result);
//        System.out.println(result1);
//        System.out.println(result2);
//
//        insert(treeNode, 12);
//        System.out.println(treeNode);

//        delete(treeNode, 30);
//        System.out.println(treeNode);

        int height = treeHeight(treeNode);
        System.out.println(height);
    }


    // 查找-递归实现
    public static TreeNode search(TreeNode node, int value) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            return node;
        } else if (node.value < value) {
            return search(node.right, value);
        } else {
            return search(node.left, value);
        }
    }

    // 查找-循环实现
    public static TreeNode searchWithCycle(TreeNode node, int value) {
        TreeNode p = node;
        while (p != null) {
            if (p.value == value) {
                return p;
            } else if (p.value < value) {
                p = node.right;
            } else {
                p = node.left;
            }
        }
        return null;
    }

    // 插入
    public static void insert(TreeNode node, int value) {
        if (node.value < value) {
            if (node.right == null) {
                node.right = new TreeNode(value, null, null);
            } else {
                insert(node.right, value);
            }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(value, null, null);
            } else {
                insert(node.left, value);
            }
        }
    }

    // 删除
    public static void delete(TreeNode node, int value) {
        // p指向要删除的节点，初始化指向根节点
        TreeNode p = node;
        // pp记录的是p的父节点
        TreeNode pp = null;
        while (p != null && p.value != value) {
            pp = p;
            if (value > p.value) p = p.right;
            else p = p.left;
        }
        if (p == null) return; //没有找到
        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            //查找又子树种最小的节点
            TreeNode minP = p.right;
            TreeNode minPP = p; // minPP表示minP的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value; // 将minP的数据替换到p中
            p = minP;// 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        TreeNode child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) node = child;// 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }

    // 求树高
    public static int treeHeight(TreeNode node) {
        int leftHeight = node.left == null ? 0 : treeHeight(node.left) + 1;
        int rightHeight = node.right == null ? 0 : treeHeight(node.right) + 1;
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
