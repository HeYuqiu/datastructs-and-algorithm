/**
 * @author Yuqiu.He
 * @date 2021/2/7
 */
public class Backtracking_01背包_优化_备忘录方式 {
    static int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
    static int n = 4; // 物品个数
    static int w = 11; // 背包承受的最大重量
    static int[] items = new int[] {5, 3, 4, 1};
    static boolean[][] mem = new boolean[n][w + 1]; // 备忘录，默认值false；

    public static void main(String[] args) {
        Backtracking_01背包_优化_备忘录方式 main = new Backtracking_01背包_优化_备忘录方式();
        main.f(0, 0);
        System.out.println(main.maxW);
    }

    // 备忘录优化：防止重复计算某个组合
    public void f(int i, int cw) {
        // cw==w表示装满了，i==n表示物品都考察完了，满足这两个终结状态则剪枝，不往下进行了
        // 这里cw不可能出现大于w的情况，因为下面if (cw + items[i] <= w)已经把这种情况过滤了
        if (cw == w || i == n) {
            if (cw > maxW)
                maxW = cw;
            return;
        }
        // 增加备忘录检查，避免重复计算
        if (mem[i][cw])
            return;
        mem[i][cw] = true;

        f(i + 1, cw); // 当前物品先选择不装进背包
        if (cw + items[i] <= w) { // 当前物品装进去后要小于背包重量才继续
            f(i + 1, cw + items[i]); // 又回溯回来，当前物品装进背包
        }
    }
}
