/**
 * 题目描述 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 示例1 输入 [4,8,6,12,16,14,10]
 *
 * 返回值 true
 * 
 * @author Yuqiu.He
 * @date 2021/2/2
 */
public class JZ23_二叉搜索树的后序遍历序列 {
    // 思路：最右边是父节点，寻找分界点，递归判断
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return helpVerify(sequence, 0, sequence.length - 1);
    }

    public boolean helpVerify(int[] sequence, int start, int root) {
        if (start >= root)
            return true;
        int midIndex = start;
        for (; midIndex < root; midIndex++) {
            if (sequence[midIndex] > sequence[root]) {
                break;
            }
        }
        for (int j = midIndex; j < root; j++) {
            if (sequence[j] < sequence[root])
                return false;
        }

        return helpVerify(sequence, start, midIndex - 1) && helpVerify(sequence, midIndex, root - 1);
    }
}
