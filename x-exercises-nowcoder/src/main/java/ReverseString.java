import java.util.Stack;

/**
 * @author Yuqiu.He
 * @date 2021/1/18
 */
public class ReverseString {

    public static void main(String[] args) {
        String d1 = "(abcd)";
        String d2 = "(u(love)i)";
        String d3 = "(i(u(wa)e)h)";
        String d4 = "a(bcdefghijkl(mno)p)q";
        System.out.println(reverseParentheses(d1));
        System.out.println(reverseParentheses(d2));
        System.out.println(reverseParentheses(d3));
        System.out.println(reverseParentheses(d4));

    }

    private static String reverseInit(String value) {
        int revNum = 0;
        for (char c : value.toCharArray()) {
            if (c == '(') {
                revNum++;
            }
        }
        if (value.startsWith("(")) {
            return reverse(value.substring(1, value.length() - 1), revNum, true);
        } else {
            String pre = value.substring(0, value.indexOf("("));
            String last = value.substring(value.lastIndexOf(")") + 1);
            String mid = value.substring(value.indexOf("(") + 1, value.lastIndexOf(")"));
            return pre + reverse(mid, revNum, true) + last;
        }
    }

    private static String reverse(String value, int revNum, boolean rev) {
        if (value.contains("(")) {
            String pre = value.substring(0, value.indexOf("("));
            String last = value.substring(value.lastIndexOf(")") + 1);
            String mid = value.substring(value.indexOf("(") + 1, value.lastIndexOf(")"));
            if (rev) {
                return reverseString(last) + reverse(mid, revNum, !rev) + reverseString(pre);
            } else {
                return pre + reverse(mid, revNum, !rev) + last;
            }
        } else {
            if (revNum % 2 == 1) {
                return reverseString(value);
            } else
                return value;
        }
    }

    public static String reverseParentheses(String value) {
        char[] chars = value.toCharArray();
        Stack<Integer> parenthesesIndexs = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                parenthesesIndexs.push(i);
            } else if (chars[i] == ')') {
                reverseCharArray(chars, parenthesesIndexs.pop(), i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (char aChar : chars) {
            if (aChar != '(' && aChar != ')') {
                res.append(aChar);
            }
        }
        return res.toString();
    }

    public static void reverseCharArray(char[] chs, int start, int end) {
        while (start < end) {
            char temp = chs[end];
            chs[end] = chs[start];
            chs[start] = temp;
            start++;
            end--;
        }
    }

    private static String reverseString(String value) {
        char[] chars = value.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        return result.toString();
    }
}
