/**
 * 题目描述 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 示例1 输入 [3,32,321]
 *
 * 返回值 "321323"
 * 
 * @author Yuqiu.He
 * @date 2021/3/12
 */
public class JZ32_把数组排成最小的数 {
    // 比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，如果s1+s2大，
    // 那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面
    public String PrintMinNumber(int[] numbers) {
        // 选择排序
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (String.valueOf(numbers[i] + "" + numbers[j]).compareTo(String.valueOf(numbers[j] + "" + numbers[i]))
                    > 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numbers.length; i++)
            str.append(numbers[i]);
        return str.toString();
    }
}
