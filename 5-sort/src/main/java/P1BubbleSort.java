/**
 * 冒泡排序
 *
 * @author Yuqiu.He
 * @date 2020-06-30
 */
public class P1BubbleSort {
    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1, 6, 3};
        sort1(a);
//        sort2(a);
//        sort3(a);
        System.out.println(a);
    }

    // 下沉式
    public static void sort1(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    // 上浮式
    public static void sort2(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = a.length - i; j > i; --j) {
                if (a[j] < a[j - 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }
}
