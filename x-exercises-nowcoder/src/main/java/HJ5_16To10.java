import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tags=&title=&diffculty=0&judgeStatus=0&rp=1
 * 题目描述 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 输入描述: 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 * 输出描述: 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * 
 * @author Yuqiu.He
 * @date 2020/12/31
 */
public class HJ5_16To10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String next = sc.next();
            next = next.substring(2);
            System.out.println(Integer.parseInt(next, 16));
        }
    }
}
