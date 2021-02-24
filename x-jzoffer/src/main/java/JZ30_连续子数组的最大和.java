/**
 * 题目描述 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 *
 * 示例1 输入 [1,-2,3,10,-4,7,2,-5]
 *
 * 返回值 18
 *
 * 说明 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 * 
 * @author Yuqiu.He
 * @date 2021/2/5
 */
public class JZ30_连续子数组的最大和 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, -2, 3, 10, -4, 7, 2, -5};
        int i = FindGreatestSumOfSubArray(arr);
        System.out.println(i);
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] = array[i - 1] + array[i];
            }
            result = Math.max(result, array[i]);
        }
        return result;
    }
}
