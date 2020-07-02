import java.util.Arrays;
import java.util.Random;

/**
 * 桶排序
 * 时间复杂度：O(n)
 * 空间复杂度：O(n) 非原地排序
 * 特殊场景使用（数据量大且桶的数量不能太多）：比如对100万个人按年龄排序，年龄按照0-120设置120个桶
 *
 * @author Yuqiu.He
 * @date 2020-07-02
 */
public class P5BucketSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            a[i] = random.nextInt(120);
        }

        int[] bubble = Arrays.copyOf(a, a.length);
        int[] insertion = Arrays.copyOf(a, a.length);
        int[] quick = Arrays.copyOf(a, a.length);

        long startTime = System.currentTimeMillis();
        sort(a);
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("桶排序耗时：" + costTime + "毫秒");

        startTime = System.currentTimeMillis();
        P4QuickSort.sort(quick);
        costTime = System.currentTimeMillis() - startTime;
        System.out.println("快速排序耗时：" + costTime + "毫秒");

        startTime = System.currentTimeMillis();
        P2InsertionSort.sort(insertion);
        costTime = System.currentTimeMillis() - startTime;
        System.out.println("插入排序耗时：" + costTime + "毫秒");

        startTime = System.currentTimeMillis();
        P1BubbleSort.sort1(bubble);
        costTime = System.currentTimeMillis() - startTime;
        System.out.println("冒泡排序耗时：" + costTime + "毫秒");
    }

    public static void sort(int[] a) {
        // 找到最大值和最小值
        int minValue = a[0];
        int maxValue = a[0];
        for (int value : a) {
            if (value < minValue)
                minValue = value;
            if (value > maxValue)
                maxValue = value;
        }

        // 确定桶数量（桶大小为1）
        int bucketCount = maxValue - minValue + 1;
        int[][] buckets = new int[bucketCount][0];

        // 将数据放到各自的桶中
        for (int i = 0; i < a.length; i++) {
            int index = a[i] - minValue;
            buckets[index] = arrAppend(buckets[index], a[i]);
        }

        // 按顺序从桶中取出数据返回
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length == 0)
                continue;
            for (int value : bucket) {
                a[arrIndex++] = value;
            }
        }
    }

    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
