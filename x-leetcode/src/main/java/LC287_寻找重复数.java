import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2] 输出：2 示例 2：
 *
 * 输入：nums = [3,1,3,4,2] 输出：3
 *
 * 进阶：
 *
 * 你可以在不修改数组 nums 的情况下解决这个问题吗？ 你可以只用常量级 O(1) 的额外空间解决这个问题吗？ 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
 *
 * @author Yuqiu.He
 * @date 2021/4/26
 */
public class LC287_寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        int cnt;
        while (left < right) {
            cnt = 0;
            int mid = (left + right) / 2;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
