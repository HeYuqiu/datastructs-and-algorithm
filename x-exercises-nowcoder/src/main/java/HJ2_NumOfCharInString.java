import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tags=&title=&diffculty=0&judgeStatus=0&rp=1
 *
 * 题目描述 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 *
 * 输入描述: 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述: 输出输入字符串中含有该字符的个数。
 * 
 * @author Yuqiu.He
 * @date 2020/12/31
 */
public class HJ2_NumOfCharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = sc.nextLine().toLowerCase().charAt(0);
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        int result = 0;
        for (char aChar : chars) {
            if (aChar == c) {
                result++;
            }
        }
        System.out.println(result);
    }
}
