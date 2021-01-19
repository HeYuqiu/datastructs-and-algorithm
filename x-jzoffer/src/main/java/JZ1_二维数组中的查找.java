/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 输入 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 
 * 返回值 true
 * 
 * @author Yuqiu.He
 * @date 2021/1/19
 */
public class JZ1_二维数组中的查找 {
    public static void main(String[] args) {

    }

    /**
     * 思路：遍历是不可能的
     *
     * 利用列和行都顺序排的特点，从"中间开始找"，即左下角，如果小了，就右移，大了就上移
     * 
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        int colMax = array[0].length - 1;
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col <= colMax) {
            if (array[row][col] < target) {
                col++;
            } else if (array[row][col] > target) {
                row--;
            }else {
                return true;
            }
        }
        return false;
    }
}
