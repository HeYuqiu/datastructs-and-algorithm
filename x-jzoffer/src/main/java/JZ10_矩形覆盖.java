/**
 * 题目描述
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 *
 * 示例1 输入 4
 *
 * 返回值 5
 * 
 * @author Yuqiu.He
 * @date 2021/1/24
 */
public class JZ10_矩形覆盖 {
    public static void main(String[] args) {
        int i = rectCover(50);
        System.out.println(i);
    }

    public static int rectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int a = 2;
        int b = 1;
        for (int i = 3; i <= target; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }
}
