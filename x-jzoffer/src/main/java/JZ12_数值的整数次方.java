/**
 * 题目描述 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 * 示例1 输入 2,3
 *
 * 返回值 8.00000
 * 
 * @author Yuqiu.He
 * @date 2021/1/25
 */
public class JZ12_数值的整数次方 {
    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }
}
