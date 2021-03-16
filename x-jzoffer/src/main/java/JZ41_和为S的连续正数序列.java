import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * Good Luck!
 *
 * 返回值描述: 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 示例1 输入 9
 *
 * 返回值 [[2,3,4],[4,5]]
 * 
 * @author Yuqiu.He
 * @date 2021/3/16
 */
public class JZ41_和为S的连续正数序列 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence_optimize(9);
    }

    // 暴力法：时间复杂度：O(n^3)
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 左边界
        for (int i = 1; i <= sum / 2; i++) {
            // 右边界
            for (int j = i + 1; j <= (sum / 2) + 1; j++) {
                ArrayList<Integer> tempList = new ArrayList<>();
                int temSum = 0;
                for (int m = i; m <= j; m++) {
                    temSum += m;
                    tempList.add(m);
                    if (temSum > sum) {
                        break;
                    }
                }
                if (temSum == sum) {
                    result.add(tempList);
                }
            }
        }
        return result;
    }

    // 滑动窗口(双指针) 时间复杂度：O(n)
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence_optimize(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 1;// 左边界
        int j = 2;// 右边界
        int tempSum = 3;
        while (j <= (sum / 2) + 1) {
            if (tempSum < sum) {
                tempSum += ++j;
            } else if (tempSum > sum) {
                tempSum -= i++;
            } else {
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int m = i; m <= j; m++) {
                    tempList.add(m);
                }
                result.add(tempList);
                tempSum += ++j;
                tempSum -= i++;
            }
        }
        return result;
    }

}
