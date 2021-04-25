import java.util.*;

/**
 * 题目描述
 * 现在有五张扑克牌，我们需要来判断一下是不是顺子。
 * 有如下规则：
 * A为1,J为11,Q为12,K为13
 * 数据中的0可以看作任意牌
 * 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
 * 例如：给出数据[6,0,2,0,4]
 * 中间的两个0一个看作3，一个看作5 。即：[6,3,2,5,4]
 * 这样这五张牌在[2,6]区间连续，输出true
 * 数据保证每组5个数字，每组最多含有4个零
 *
 * 示例1
 * 输入
 * [0,3,2,6,4]
 *
 * 返回值
 * true
 * @author Yuqiu.He
 * @date 2021/4/25
 */
public class JZ45_扑克牌顺子 {
    public static void main(String[] args) {
        JZ45_扑克牌顺子 main = new JZ45_扑克牌顺子();
        int [] numbers =new int[]{1,3,0,7,0};
        boolean b = main.IsContinuous(numbers);
    }

    public boolean IsContinuous(int [] numbers) {
        // 5个连续数字，最大值和最小值差在5以内
        int zeroNum = 0;
        TreeSet<Integer> set = new TreeSet();
        for(int item : numbers){
            if(item==0){
                zeroNum++;
            }else{
                set.add(item);
            }
        }
        if((set.size()+zeroNum)!=5){
            return false;
        }
        if((set.last()-set.first())>=5){
            return false;
        }
        return true;
    }

}
