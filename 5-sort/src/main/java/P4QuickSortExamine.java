/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1) 原地排序
 * 常用算法，分治思想，递归算法，大数据专用
 *
 * @author Yuqiu.He
 * @date 2020-07-01
 */
public class P4QuickSortExamine {

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 1, 6, 3, 4, 7, 8, 9, 11, 3, 23, 8, 10, 25, 11, 2, 19};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(a, left, right);
            quickSort(a, left, partitionIndex - 1);
            quickSort(a, partitionIndex + 1, right);
        }
    }

    public static int partition(int[] a, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] < a[pivot]) {
                swap(a, i, index);
                index++;
            }
        }
        swap(a, pivot, index - 1);
        return index - 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
