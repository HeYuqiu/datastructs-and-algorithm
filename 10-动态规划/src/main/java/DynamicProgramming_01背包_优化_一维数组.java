/**
 * 动态规划的方式求解01背包问题
 *
 * @author Yuqiu.He
 * @date 2021/2/8
 */
public class DynamicProgramming_01背包_优化_一维数组 {
    static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    static int n = 4; // 物品个数
    static int w = 11; // 背包承受的最大重量
    static int[] items = new int[] {5, 3, 4, 1};

    public static void main(String[] args) {
        DynamicProgramming_01背包_优化_一维数组 main = new DynamicProgramming_01背包_优化_一维数组();
        main.f();
        System.out.println(main.maxW);
    }

    // 空间复杂度优化：实际上，只需要一个一维数组就可以传递每个阶段的最终状态，因为之前阶段的状态已经用不上了，最新的状态包含了之前的状态
    public void f() {
        boolean[] states = new boolean[w + 1]; // 用于存储状态列表，默认值false，true表示存在这种情况
        states[0] = true;
        if (items[0] <= w) {
            states[items[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            // 不把第i个物品放进去的情况不需要处理，因为当前状态已经包含了这种情况
            for (int p = w - items[i]; p >= 0; p--) { // 把第i个物品放进去，这里需要从大到小处理，不然会出现重复计算
                if (states[p])
                    states[p + items[i]] = true;
            }
        }

        // 输出结果
        for (int i = w; i >= 0; i--) {
            if (states[i]) {
                maxW = i;
                return;
            }
        }
    }
}
