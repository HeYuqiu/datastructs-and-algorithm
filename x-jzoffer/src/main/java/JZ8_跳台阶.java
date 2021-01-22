/**
 * 题目描述 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 示例1 输入 1
 *
 * 返回值 1
 *
 * 示例2 输入 4 返回值 5
 * 
 * @author Yuqiu.He
 * @date 2021/1/22
 */
public class JZ8_跳台阶 {
    // 递归时间复杂度为O(n^2)，很多重复计算
    public int JumpFloor(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    // 循环的方式，时间复杂度为O(n)
    public int jumpFloor(int target) {
        int a = 1; // 表示target步数-1的情况
        int b = 1; // 表示target步数-2的情况
        for (int i = 1; i < target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
