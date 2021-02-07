import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 示例1 输入 [1,2,3,2,2,2,5,4,2]
 *
 * 返回值 2
 * 
 * @author Yuqiu.He
 * @date 2021/2/5
 */
public class JZ28_数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] num = new int[] {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = MoreThanHalfNum_Solution(num);
        System.out.println(i);
    }

    // 时间复杂度：O(n),空间复杂度：O(n)
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 1)
            return array[0];
        Map<Integer, Integer> countStat = new HashMap<>();
        for (int i : array) {
            Integer count = countStat.get(i);
            if (count == null) {
                countStat.put(i, 1);
            } else if ((count + 1) > (array.length / 2)) {
                return i;
            } else {
                countStat.put(i, ++count);
            }
        }
        return 0;
    }

    // 时间复杂度：O(n),空间复杂度：O(1)
    // 思路：先一次遍历找到出现次数最多的数，再一次遍历确定其是不是超过了一半
    public static int MoreThanHalfNum_Solution_opt(int[] array) {
        // 用preValue记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；如果不同count--，减到0的时候就要更换新的preValue值了，因为如果存在超过数组长度一半的值，那么最后preValue一定会是该值。
        // 相互抵消法
        if(array == null || array.length == 0)return 0;
        int preValue = array[0];//用来记录上一次的记录
        int count = 1;//preValue出现的次数（相减之后）
        for(int i = 1; i < array.length; i++){
            if(array[i] == preValue)
                count++;
            else{
                count--;
                if(count == 0){
                    preValue = array[i];
                    count = 1;
                }
            }
        }
        int num = 0;//需要判断是否真的是大于1半数，这一步骤是非常有必要的，因为我们的上一次遍历只是保证如果存在超过一半的数就是preValue，但不代表preValue一定会超过一半
        for(int i=0; i < array.length; i++)
            if(array[i] == preValue)
                num++;
        return (num > array.length/2)?preValue:0;
    }
}
