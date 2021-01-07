import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目描述 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 示例1 输入 [4,5,1,6,2,7,3,8],4
 * 返回值
 * [1,2,3,4]
 * 
 * @author Yuqiu.He
 * @date 2021/1/6
 */
public class H2_MinimumNumbers {
    public static void main(String[] args) {
        int [] input = new int[]{4,5,1,6,2,7,3,8};
        int k =4;
        ArrayList<Integer> integers = GetLeastNumbers_Solution(input, 4);
        System.out.println(integers);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i : input) {
            treeSet.add(i);
        }
        for (int i = 0; i < k; i++) {
            result.add(treeSet.pollFirst());
        }
        return result;
    }
}
