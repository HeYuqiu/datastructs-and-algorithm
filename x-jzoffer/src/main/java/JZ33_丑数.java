/**
 * 题目描述 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 示例1 输入 7
 *
 * 返回值 8
 * 
 * @author Yuqiu.He
 * @date 2021/3/12
 */
public class JZ33_丑数 {

    // 动态规划
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        int[] result = new int[index];
        result[0] = 1;
        int p2Index = 0, p3Index = 0, p5Index = 0;
        for (int i = 1; i < index; i++) {
            int nextP2 = result[p2Index] * 2;
            int nextP3 = result[p3Index] * 3;
            int nextP5 = result[p5Index] * 5;
            result[i] = Math.min(nextP2, Math.min(nextP3, nextP5));
            if (result[i] == nextP2)
                p2Index++;
            if (result[i] == nextP3)
                p3Index++;
            if (result[i] == nextP5)
                p5Index++;
        }
        return result[index - 1];
    }

}
