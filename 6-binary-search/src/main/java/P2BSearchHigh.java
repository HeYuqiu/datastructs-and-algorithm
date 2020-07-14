/**
 * 二分查找变种
 *
 * @author Yuqiu.He
 * @date 2020-07-06
 */
public class P2BSearchHigh {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 4, 7, 7, 7, 8, 9, 11, 13, 13, 16, 16};
        int firstEqual = firstEqual(a, 4);
        System.out.println(firstEqual);
        int firstGrEqual = firstGrEqual(a, 5);
        System.out.println(firstGrEqual);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return  n + 1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public static int firstEqual(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid != 0 && a[mid - 1] == value) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param value
     * @return
     */
    public static int firstGrEqual(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value)
                    return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
