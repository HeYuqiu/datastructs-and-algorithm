import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]] 示例 2：
 *
 * 输入：nums = [] 输出：[] 示例 3：
 *
 * 输入：nums = [0] 输出：[]
 *
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Yuqiu.He
 * @date 2021/5/6
 */
public class LC15_三数之和 {
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(ints);
        System.out.println(lists);
    }

    // 思路：暴力法三层循环时间复杂度O(n^3)肯定不行
    // 利用双指针将时间复杂度降低至O(n^2)
    // 先排序O(nlogn),然后先定一个基准数，利用双指针，去找另外两个数，找另外两个数时间复杂度为n;
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int ans = nums[i] + nums[left] + nums[right];
                if (ans == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (ans > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
