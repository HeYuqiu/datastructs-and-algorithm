import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/ 在一个非负整数 a
 * 中，我们希望从中移除 k 个数字，让剩下的数字值最小，如何选择移除哪 k 个数字呢？
 * 
 * @author Yuqiu.He
 * @date 2021/2/7
 */
public class Greedy_最小整数 {
    public static void main(String[] args) {
        System.out.println("4571243,4->" + min(4571243, 4));
        System.out.println("4571243,3->" + min(4571243, 3));
        System.out.println("4571243,5->" + min(4571243, 5));
        System.out.println("123456,3->" + min(123456, 3));
        System.out.println("7654321,4->" + min(7654321, 4));
        System.out.println("154091021,5->" + min(154091021, 5));
        System.out.println("563910320,4->" + min(563910320, 4));
    }

//    // 思路：先确定最左边的数，依次到最右边的数
//    public static int min(int a, int k) {
//        // 整数转成字符串，即可分别获取每位数字！！！
//        String aStr = a + "";
//        char[] chars = aStr.toCharArray();
//        int curIndex = 0;
//        while (k > 0 && curIndex < chars.length) {
//            char minValue = chars[curIndex];
//            int kRemoveCount = 0;
//            for (int i = curIndex + 1; i <= curIndex + k && i < chars.length; i++) {
//                if (chars[i] < minValue) {
//                    minValue = chars[i];
//                    // 前面的都要被移除
//                    kRemoveCount = 0;
//                    for (int j = curIndex; j < i; j++) {
//                        chars[j] = 'r';
//                        kRemoveCount++;
//                    }
//                }
//            }
//            k -= kRemoveCount;
//            curIndex = curIndex + kRemoveCount + 1;
//        }
//
//        if (k > 0) {
//            for (int i = chars.length - 1; i >= 0; i--) {
//                if (k <= 0)
//                    break;
//                if (chars[i] != 'r') {
//                    k--;
//                    chars[i] = 'r';
//                }
//            }
//        }
//
//        String result = new String(chars);
//        return Integer.parseInt(result.replace("r", ""));
//    }

    // 优化：用栈来解决
    public static int min(int a, int k) {
        String aStr = a + "";
        char[] chars = aStr.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char digit = chars[i];
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 现在栈里的数据就是结果，整理处理，然后倒序一下
        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return Integer.parseInt(new String(result));
    }
}
