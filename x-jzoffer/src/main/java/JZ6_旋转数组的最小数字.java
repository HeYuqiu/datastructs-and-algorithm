/**
 * 题目描述
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 示例1 输入 [3,4,5,1,2]
 *
 * 返回值 1
 *
 * @author Yuqiu.He
 * @date 2021/1/21
 */
public class JZ6_旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] array = new int[] {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895,
            9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812,
            3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        int i = minNumberInRotateArray(array);
        System.out.println(i);
    }

    // 二分查找
    public static int minNumberInRotateArray(int[] array) {
        int index = 0;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex < highIndex) {
            if (array[lowIndex] < array[highIndex])
                return array[lowIndex];
            index = lowIndex + (highIndex - lowIndex) / 2;
            if (array[index] > array[lowIndex]) {
                lowIndex = index + 1;
            } else if (array[index] < array[highIndex]) {
                highIndex = index;
            } else {
                lowIndex++;
            }
        }
        return array[lowIndex];
    }
}
