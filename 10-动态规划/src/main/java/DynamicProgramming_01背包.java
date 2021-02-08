/**
 * 动态规划的方式求解01背包问题
 * 
 * @author Yuqiu.He
 * @date 2021/2/8
 */
public class DynamicProgramming_01背包 {
    static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    static int n = 4; // 物品个数
    static int w = 11; // 背包承受的最大重量
    static int[] items = new int[] {5, 3, 4, 1};

    public static void main(String[] args) {
        DynamicProgramming_01背包 main = new DynamicProgramming_01背包();
        main.f();
        System.out.println(main.maxW);
    }

    // 动态规划：根据物品数量把问题分为n个阶段，每个阶段对应一个决策，决策后有多个状态（去掉重复的状态），
    // 保存每个阶段的状态值，然后以当前阶段的状态集合来推导下一阶段的状态集合，动态的往前推进；
    // 直到推导至最后一个阶段，然后找出最优值
    public void f() {
        boolean[][] states = new boolean[n][w + 1]; // 用于存储状态列表，默认值false，true表示存在这种情况
        states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[0][items[0]] = true;
        }

        for (int i = 1; i < n; i++) { // 动态规划状态转移
            for (int p = 0; p <= w; p++) { // 不把第i个物品放进去
                if (states[i - 1][p])
                    states[i][p] = true;
            }
            for (int p = 0; p <= w - items[i]; p++) { // 把第i个物品放进去
                if (states[i - 1][p])
                    states[i][p + items[i]] = true;
            }
        }

        // 输出结果
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                maxW = i;
                return;
            }
        }
    }
}
