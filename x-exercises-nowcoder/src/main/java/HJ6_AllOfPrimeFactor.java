import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tags=&title=&diffculty=0&judgeStatus=0&rp=1
 * 题目描述 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 输入描述: 输入一个long型整数
 *
 * 输出描述: 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * 
 * @author Yuqiu.He
 * @date 2020/12/31
 */
public class HJ6_AllOfPrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        primeFactor(l);
    }

    private static void primeFactor(long l) {
        long num = l;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i+" ");
                primeFactor(l/i);
                break;
            }
        }
    }
}
