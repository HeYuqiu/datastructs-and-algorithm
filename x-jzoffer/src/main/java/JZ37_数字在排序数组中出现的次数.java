/**
 * 题目描述 统计一个数字在升序数组中出现的次数。
 *
 * 示例1 输入 [1,2,3,3,3,3,4,5],3
 *
 * 返回值 4
 * 
 * @author Yuqiu.He
 * @date 2021/3/15
 */
public class JZ37_数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        int result = 0;
        for (int i : array) {
            if (i == k) {
                result++;
            }
            if (i > k) {
                break;
            }
        }
        return result;
    }
}
