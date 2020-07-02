/**
 * 插入排序
 *
 * @author Yuqiu.He
 * @date 2020-07-01
 */
public class P2InsertionSort {

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1, 6, 3};
        sort(a);
        System.out.println(a);
    }

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            // 查找插入的位置
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) { // 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;   // 插入数据
        }
    }
}
