import java.util.Stack;

/**
 * @author Yuqiu.He
 * @date 2021/1/18
 */
public class ReverseParentheses {
    public static void main(String[] args) {
        ReverseParentheses ob = new ReverseParentheses();
        String d1 = "(abcd)";
        String d2 = "(u(love)i)";
        String d3 = "(i(u(wa)e)h)";
        String d4 = "a(bcdefghijkl(mno)p)q";
        System.out.println(ob.reverseParentheses(d1));
        System.out.println(ob.reverseParentheses(d2));
        System.out.println(ob.reverseParentheses(d3));
        System.out.println(ob.reverseParentheses(d4));
    }

    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                stack.push(i);
            } else if (chs[i] == ')') {
                reverse(chs, stack.pop() + 1, i - 1);
            }
        }
        for (char ch : chs) {
            if (ch != '(' && ch != ')') {
                res.append(ch);
            }
        }
        return res.toString();
    }

    private void reverse(char[] chs, int start, int end) {
        while (end > start) {
            char temp = chs[end];
            chs[end] = chs[start];
            chs[start] = temp;
            start++;
            end--;
        }
    }
}
