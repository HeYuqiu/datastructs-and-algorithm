import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 示例1
 * 输入
 * [4,5,1,6,2,7,3,8],4
 *
 * 返回值
 * [1,2,3,4]
 * @author Yuqiu.He
 * @date 2021/2/5
 */
public class JZ29_最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(k<=input.length){
            TreeSet<Integer> treeSet = new TreeSet();
            for (int i : input) {
                treeSet.add(i);
            }
            for (int i = 0; i < k; i++) {
                result.add(treeSet.pollFirst());
            }
        }

        return result;
    }
}
