/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 
 * @author Yuqiu.He
 * @date 2021/1/19
 */
public class JZ2_替换空格 {
    public static void main(String[] args) {

    }

    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    public String replaceSpace1(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }
}
