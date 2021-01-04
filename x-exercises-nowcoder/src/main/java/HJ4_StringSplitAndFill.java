import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tags=&title=&diffculty=0&judgeStatus=0&rp=1
 * 
 * 题目描述 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组； •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述: 连续输入字符串(输入多次,每个字符串长度小于100)
 *
 * 输出描述: 输出到长度为8的新字符串数组
 * 
 * @author Yuqiu.He
 * @date 2020/12/31
 */
public class HJ4_StringSplitAndFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> arr = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
            arr.add(s);
        }
        for (String it : arr) {
            int n = 0;
            StringBuilder out = new StringBuilder();
            for (char c : it.toCharArray()) {
                if (++n == 9) {
                    System.out.println(out.toString());
                    n = 1;
                    out = new StringBuilder();
                }
                out.append(c);
            }
            if (n > 0) {
                for (int i = out.length(); i < 8; i++) {
                    out.append(0);
                }
                System.out.println(out.toString());
            }
        }
    }
}
