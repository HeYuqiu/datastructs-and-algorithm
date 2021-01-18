/**
 * @author Yuqiu.He
 * @date 2021/1/9
 */
public class HJM {
    public static void main(String[] args) {
        String[] words = new String[] {"a", "banana", "app", "appl", "ap","apply","apple"};
        String s = longestWord(words);
        System.out.println(s);
    }

    public static String longestWord(String[] words) {
        String result = null;
        for (String word : words) {
            if (result != null) {
                if (word.length() > result.length()) {
                    if (canFind(words, word)) {
                        result = word;
                    }
                } else if (word.length() == result.length()
                    && word.charAt(word.length() - 1) < result.charAt(result.length() - 1)) {
                    if (canFind(words, word)) {
                        result = word;
                    }
                }
            } else {
                if (canFind(words, word)) {
                    result = word;
                }
            }
        }
        return result;
    }

    public static boolean canFind(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                if (target.length() == 1) {
                    return true;
                }
                return canFind(words, target.substring(0, target.length() - 1));
            }
        }
        return false;
    }
}
