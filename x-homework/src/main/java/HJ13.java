import java.util.HashSet;
import java.util.Set;

/**
 * @author Yuqiu.He
 * @date 2021/1/15
 */
public class HJ13 {
    public static void main(String[] args) {
        String[] words
            = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple", "aeelf", "ae", "aee", "aeel"};
        String s = longestWord(words);
        System.out.println(s);
    }

    public static String longestWord(String[] words) {
        sort(words);
        Set<String> treeSet = new HashSet<>();
        for (String word : words) {
            treeSet.add(word);
        }
        String result = "";
        for (String s : words) {
            if (s.length() < result.length()) {
                return result;
            } else if (s.compareTo(result) < 0 && canFind(treeSet, s)) {
                result = s;
            }
        }
        return result;
    }

    public static boolean canFind(Set<String> words, String target) {
        if (words.contains(target)) {
            return target.length() == 1 ? true : canFind(words, target.substring(0, target.length() - 1));
        } else {
            return false;
        }
    }

    public static void sort(String[] words) {
        // todo
    }
}
