import java.util.ArrayList;

/**
 * 题目描述 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 返回值描述: 对应每个测试案例，输出两个数，小的先输出。
 *
 * 示例1 输入 [1,2,4,7,11,15],15
 *
 * 返回值 [4,11]
 * 
 * @author Yuqiu.He
 * @date 2021/3/16
 */
public class JZ42_和为S的两个数字 {
    // 双指针 从两端往中间移动，会覆盖所有可能的情况
    // 最外层的乘积最小
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] < sum) {
                i++;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(array[i]);
                result.add(array[j]);
                return result;
            }
        }
        return new ArrayList<>();
    }
}
