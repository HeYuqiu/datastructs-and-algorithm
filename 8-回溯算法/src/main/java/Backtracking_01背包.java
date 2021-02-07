/**
 * @author Yuqiu.He
 * @date 2021/2/7
 */
public class Backtracking_01背包 {
    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    public static void main(String[] args) {
        Backtracking_01背包 main = new Backtracking_01背包();
        int[] items = new int[] {5, 3, 4, 1};
        int n = 4;
        int w = 11;
        main.f(0, 0, items, n, w);
        System.out.println(main.maxW);
    }

    // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
    // w背包重量；items表示每个物品的重量；n表示物品个数
    // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    // 循环过程：1表示放，0表示不放，4个物品，列出所有满足条件的情况，选最优的
    // 0000
    // 0001
    // 0010
    // 0011
    // 0100
    // 0101
    // ...
    public void f(int i, int cw, int[] items, int n, int w) {
        if (i == n) { // i==n表示已经考察完所有的物品
            if (cw > maxW && cw <= w) // 不能超过背包重量
                maxW = cw;
            return;
        }
        f(i + 1, cw, items, n, w); // 当前物品先选择不装进背包
        f(i + 1, cw + items[i], items, n, w); // 又回溯回来，当前物品装进背包
    }
}
