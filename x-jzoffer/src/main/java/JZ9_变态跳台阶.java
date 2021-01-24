/**
 * 题目描述 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 示例1 输入 3
 * 
 * 返回值 4
 * 
 * @author Yuqiu.He
 * @date 2021/1/24
 */
public class JZ9_变态跳台阶 {
    // f(n) = f(n-1)+f(n-2)+f(n-3)+...+f(1)
    // f(n-1) = f(n-2)+f(n-3)+...+f(1)
    // 带入 1中得到f(n) = 2f(n-1)
    public int JumpFloorII(int target) {
        if (target == 1 || target == 0)
            return 1;
        int a = 1;
        int b = 1;
        for (int i = 1; i < target; i++) {
            a = b << 1; // 左移乘以2，右移除以2
            b = a;
        }
        return a;
    }
}
