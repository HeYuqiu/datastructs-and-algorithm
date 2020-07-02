/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1) 原地排序
 * 常用算法，分治思想，递归算法，大数据专用
 *
 * @author Yuqiu.He
 * @date 2020-07-01
 */
public class P4QuickSort {

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1, 6, 3, 4, 7, 8, 9, 11, 3, 23, 8, 10, 25, 11, 2, 19};
        sort(a);
        System.out.println(a);
    }

    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(a, left, right);
            quickSort(a, left, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, right);
        }
    }

    // 获取分区点，重新组合数组：小于分区点放左边，大于分区点放右边(只会影响到left到right这一段数据区间)
    private static int partition(int[] a, int left, int right) {
        // 以left作为基准值
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (a[i] < a[pivot]) {
                swap(a, index, i);
                index++;
            }
        }
        // 基准值放到中间
        swap(a, index - 1, pivot);
        return index - 1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
