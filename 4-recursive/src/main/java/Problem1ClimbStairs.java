import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 爬楼梯：每次一个或两个台阶，多少种爬法
 * <p>
 * 可以根据第一步的走法把所有走法分为两类，第一类是第一步走了 1 个台阶，另一类是第一步走了 2 个台阶。所以 n 个台阶的走法就等于先走 1 阶后，n-1 个台阶的走法 加上先走 2 阶后，n-2 个台阶的走法。用公式表示就是：
 * f(n) = f(n-1)+f(n-2)
 *
 * @author Yuqiu.He
 * @date 2020-06-29
 */
public class Problem1ClimbStairs {
    private static Map<Integer, Integer> hasSolvedList = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(climbStairs(100));
        System.out.println(climbStairsOptimize(10));
        System.out.println(climbStairsCycle(10));
    }

    public static long climbStairs(int stairsNum) {
        if (stairsNum == 1) return 1;
        if (stairsNum == 2) return 2;
        return climbStairs(stairsNum - 1) + climbStairs(stairsNum - 2);
    }

    // 避免重复计算
    public static int climbStairsOptimize(int stairsNum) {
        if (stairsNum == 1) return 1;
        if (stairsNum == 2) return 2;
        if (hasSolvedList.containsKey(stairsNum)) {
            return hasSolvedList.get(stairsNum);
        }
        int result = climbStairsOptimize(stairsNum - 1) + climbStairsOptimize(stairsNum - 2);
        hasSolvedList.put(stairsNum, result);
        return result;
    }

    // 递归转为非递归（循环迭代），可有效避免堆栈溢出
    public static int climbStairsCycle(int stairsNum) {
        if (stairsNum == 1) return 1;
        if (stairsNum == 2) return 2;
        int result = 0;
        int r1 = 1;
        int r2 = 2;
        for (int i = 3; i <= stairsNum; i++) {
            result = r1 + r2;
            r1 = r2;
            r2 = result;
        }
        return result;
    }
}
