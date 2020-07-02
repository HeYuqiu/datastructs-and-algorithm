/**
 * 选择排序
 *
 * @author Yuqiu.He
 * @date 2020-07-01
 */
public class P3SelectSort {
    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1, 6, 3};
        sort(a);
        System.out.println(a);
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int minIndex = i;
            // 查找最小值序号
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // 交换
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
            }
        }
    }
}
