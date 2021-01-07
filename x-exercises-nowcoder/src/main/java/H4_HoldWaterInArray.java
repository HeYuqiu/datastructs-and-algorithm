/**
 * https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=188&&tqId=37009&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 * 题目描述 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 * 
 * 示例1 输入 [3,1,2,5,2,4]
 *
 * 返回值 5
 * 
 * @author Yuqiu.He
 * @date 2021/1/6
 */
public class H4_HoldWaterInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 1, 3, 2};
        long l = maxWater(arr);
        System.out.println(l);
    }

    /**
     * max water
     * 
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public static long maxWater(int[] arr) {
        long water = 0;
        long currWater = 0;
        int head = arr[0];
        int headIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i - headIndex == 1 && head < arr[i]) {
                head = arr[i];
                headIndex = i;
            } else if (arr[i] >= head) {
                water += currWater;
                currWater = 0;
                head = arr[i];
                headIndex = i;
            } else {
                currWater += head - arr[i];
            }
        }
        return water;
    }
}
