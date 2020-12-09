import java.util.List;

/**
 * 有一堆坐标points [x, y]，坐标之间有path关系[p1, p2, distance]。根据上述信息，任意给出两个坐标，计算出最近的距离。
 *
 * @author Yuqiu.He
 * @date 2020/12/1
 */
public class ShortestDistance {

    public static class Point {
        public int x;
        public int y;
    }

    public static class Distance {
        public Point p1;
        public Point p2;
        public int distance;
//        public void check() {
//            if (Math.abs(p1.x - p2.x) > 1 || Math.abs(p1.y - p2.y) > 1) {
//                throw new RuntimeException("P1 and P2 are not adjacent coordinates");
//            }
//        }
    }

    /**
     * Calculate the shortest distance between two coordinates
     *
     * @param xSize     the size of x
     * @param ySize     the size of y
     * @param distances Distance data between all coordinates
     * @param p1        The target coordinates P1
     * @param p2        The target coordinates P2
     * @return
     */
    public int shortestD(int xSize, int ySize, List<Distance> distances, Point p1, Point p2) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
