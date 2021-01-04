import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * <p>
 * 题目描述 计算字符串最后一个单词的长度，单词以空格隔开。
 * <p>
 * 输入描述: 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述: 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @author Yuqiu.He
 * @date 2020/12/31
 */
public class HJ1_LengthOfLastChars {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        System.out.println(lengthOfLast(s));
    }

    public static int lengthOfLast(String s) {
        int i = s.lastIndexOf(" ");
        if (i == -1) {
            return s.length();
        }
        String substring = s.substring(i);
        return substring.length() - 1;
    }
}
