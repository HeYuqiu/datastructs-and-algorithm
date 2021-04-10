/**
 * @author Yuqiu.He
 * @date 2021/4/10
 */
public class LC5_最长回文子串 {
    public static void main(String[] args) {
        LC5_最长回文子串 ob = new LC5_最长回文子串();
        String cbbd = ob.longestPalindrome2("babad");
        System.out.println(cbbd);

    }

    // 暴力法
    public String longestPalindrome1(String s) {
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String temp = s.substring(i, j + 1);
                if (temp.length() > 1 && isPalindrome(temp)) {
                    result = temp.length() > result.length() ? temp : result;
                }
            }
        }
        return result;
    }

    // 判断字符串是否是回文字符串
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 中心扩散法
    public String longestPalindrome2(String s) {
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String singleCenter = centerSpreadMaxStr(s, i, i);
            String doubleCenter = centerSpreadMaxStr(s, i, i + 1);
            String tempResult = singleCenter.length() > doubleCenter.length() ? singleCenter : doubleCenter;
            result = tempResult.length() > result.length() ? tempResult : result;
        }
        return result;
    }

    // 查找以某个中心扩散的最大回文串
    public String centerSpreadMaxStr(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // 动态规划
    public String longestPalindrome3(String s) {
        return null;
    }

}
