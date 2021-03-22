/**
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 示例1
 * 输入
 * "nowcoder. a am I"
 *
 * 返回值
 * "I am a nowcoder."
 * @author Yuqiu.He
 * @date 2021/3/22
 */
public class JZ44_翻转单词顺序列 {
    public static void main(String[] args) {
        String s = ReverseSentence("   ");
    }
    public static String ReverseSentence(String str) {
        if(str.length() <= 0 || str.trim().equals("")){//需要将多个空格的情况考虑进来
            return str;
        }
        StringBuilder result = new StringBuilder();
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            result.append(s[i]+" ");
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}
