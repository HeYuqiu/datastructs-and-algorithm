/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2] 输出：2.00000 解释：合并数组 = [1,2,3] ，中位数 2 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4] 输出：2.50000 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0] 输出：0.00000 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1] 输出：1.00000 示例 5：
 *
 * 输入：nums1 = [2], nums2 = [] 输出：2.00000
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Yuqiu.He
 * @date 2021/3/30
 */
public class LC4_寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] n1 = new int[] {1, 3};
        int[] n2 = new int[] {2};
        double medianSortedArrays = findMedianSortedArrays(n1, n2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1 == null ? 0 : nums1.length;
        int num2Length = nums2 == null ? 0 : nums2.length;
        int[] result = new int[num1Length + num2Length];
        int num1Index = 0;
        int num2Index = 0;
        int resultIndex = 0;
        while (num1Index < num1Length || num2Index < num2Length) {
            if (num1Length == 0 || num1Index > num1Length - 1) {
                result[resultIndex++] = nums2[num2Index++];
            } else if (num2Length == 0 || num2Index > num2Length - 1) {
                result[resultIndex++] = nums1[num1Index++];
            } else if (nums1[num1Index] < nums2[num2Index]) {
                result[resultIndex++] = nums1[num1Index++];
            } else {
                result[resultIndex++] = nums2[num2Index++];
            }
        }

        if (result.length > 1) {
            if (result.length % 2 == 0) {
                return (double) (result[result.length / 2 - 1] + result[result.length / 2]) / 2;
            } else {
                return result[result.length / 2];
            }
        } else {
            return result[0];
        }

    }
}
