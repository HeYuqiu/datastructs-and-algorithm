/**
 * 题目描述 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 *
 * 示例1 输入 10
 *
 * 返回值 2
 * 
 * @author Yuqiu.He
 * @date 2021/1/25
 */
public class JZ11_二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
