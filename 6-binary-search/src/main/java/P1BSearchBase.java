/**
 * 二分查找
 *
 * @author Yuqiu.He
 * @date 2020-07-03
 */
public class P1BSearchBase {

    // 非递归实现
    public int bSearch(int[] a, int value) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            if (value == a[mid]) {
                return mid;
            } else if (value < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 递归实现
    public int bSearchRecuisive(int[] a, int value) {
        return bSearchRecuisiveInternal(a, 0, a.length - 1, value);
    }

    private int bSearchRecuisiveInternal(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (value < a[mid]) {
            return bSearchRecuisiveInternal(a, low, mid - 1, value);
        } else {
            return bSearchRecuisiveInternal(a, mid + 1, high, value);
        }
    }
}
