/**
 * @author Yuqiu.He
 * @date 2021/2/7
 */
public class Backtracking_01背包_优化_剪枝 {
    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    public static void main(String[] args) {
        Backtracking_01背包_优化_剪枝 main = new Backtracking_01背包_优化_剪枝();
        int[] items = new int[] {5, 3, 4, 1};
        int n = 4;
        int w = 11;
        main.f(0, 0, items, n, w);
        System.out.println(main.maxW);
    }

    // 剪枝优化：已经超过了背包重量就不继续往下了
    public void f(int i, int cw, int[] items, int n, int w) {
        // cw==w表示装满了，i==n表示物品都考察完了，满足这两个终结状态则剪枝，不往下进行了
        // 这里cw不可能出现大于w的情况，因为下面if (cw + items[i] <= w)已经把这种情况过滤了
        if (cw == w || i == n) {
            if (cw > maxW)
                maxW = cw;
            return;
        }
        f(i + 1, cw, items, n, w); // 当前物品先选择不装进背包
        if (cw + items[i] <= w) { // 当前物品装进去后要小于背包重量才继续
            f(i + 1, cw + items[i], items, n, w); // 又回溯回来，当前物品装进背包
        }
    }
}
