import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 题目描述 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述: 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 示例1 输入 "ab"
 *
 * 返回值 ["ab","ba"]
 * 
 * @author Yuqiu.He
 * @date 2021/2/4
 */
public class JZ27_字符串的排列 {
    // fun(a,b,c) = a(fun(b,c))+b(fun(a,c))+c(fun(a,b))
    public ArrayList<String> Permutation(String str) {
        Set<String> setResult = permutationHelp(new StringBuilder(str));
        return new ArrayList<String>(setResult);
    }

    public Set<String> permutationHelp(StringBuilder str) {
        Set<String> result = new TreeSet<>();
        if (str.length() == 1) {
            result.add(str.toString());
        } else {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                StringBuilder subStr = new StringBuilder(str);
                Set<String> subResult = permutationHelp(subStr.deleteCharAt(i));
                for (String s : subResult) {
                    result.add(c + s);
                }
            }
        }
        return result;
    }
}
