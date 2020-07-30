import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Yuqiu.He
 * @date 2020-07-16
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;


    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.PrettyFormat);
    }

    public static TreeNode init() {
        TreeNode treeNode1 = new TreeNode(10, null, null);
        TreeNode treeNode2 = new TreeNode(20, treeNode1, null);

//        TreeNode treeNode35 = new TreeNode(35, null, null);
//        TreeNode treeNode45 = new TreeNode(45, null, null);
//        TreeNode treeNode4 = new TreeNode(40, treeNode35, treeNode45);

        TreeNode treeNode4 = new TreeNode(40, null, null);
        TreeNode treeNode3 = new TreeNode(30, treeNode2, treeNode4);

        TreeNode treeNode7 = new TreeNode(70, null, null);
        TreeNode treeNode6 = new TreeNode(60, null, treeNode7);
        TreeNode treeNode9 = new TreeNode(90, null, null);
        TreeNode treeNode8 = new TreeNode(80, treeNode6, treeNode9);

        TreeNode treeNode5 = new TreeNode(50, treeNode3, treeNode8);
        return treeNode5;
    }
}
