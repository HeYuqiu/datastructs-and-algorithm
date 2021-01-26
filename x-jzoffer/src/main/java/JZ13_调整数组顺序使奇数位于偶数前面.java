/**
 * 题目描述
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author Yuqiu.He
 * @date 2021/1/25
 */
public class JZ13_调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        JZ13_调整数组顺序使奇数位于偶数前面 main = new JZ13_调整数组顺序使奇数位于偶数前面();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        main.reOrderArray(array);
        System.out.println(array);
    }

    // 一趟搞定，时间复杂度O(n) ,空间复杂度O(1)，但是这样的结果不支持排序
    public void reOrderArray(int[] array) {
        int evenIndex = array.length - 1;
        for (int i = 0; i < evenIndex; i++) {
            if (array[i] % 2 == 0) {
                while (array[evenIndex] % 2 == 0) {
                    evenIndex--;
                }
                swap(array, evenIndex--, i);
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
