import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能 set(key, value)：将记录(key, value)插入该结构 get(key)：返回key对应的value值 [要求]
 * set和get方法的时间复杂度为O(1) 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。 若opt=1，接下来两个整数x,
 * y，表示set(x, y) 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1 对于每个操作2，输出一个答案 示例1 输入 复制
 * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3 返回值 复制 [1,-1] 说明 第一次操作后：最常使用的记录为("1", 1) 第二次操作后：最常使用的记录为("2",
 * 2)，("1", 1)变为最不常用的 第三次操作后：最常使用的记录为("3", 2)，("1", 1)还是最不常用的 第四次操作后：最常用的记录为("1", 1)，("2", 2)变为最不常用的
 * 第五次操作后：大小超过了3，所以移除此时最不常使用的记录("2", 2)，加入记录("4", 4)，并且为最常使用的记录，然后("3", 2)变为最不常使用的记录
 * 
 * @author Yuqiu.He
 * @date 2021/4/25
 */
public class ProblemLRU_Optimize {
    private Map<Integer, Node> map = new HashMap();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int cap;

    public static void main(String[] args) {
        ProblemLRU_Optimize main = new ProblemLRU_Optimize();
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int[] lru = main.LRU(operators, 3);
        System.out.println(lru);
    }

    /**
     * lru design
     * 
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        this.cap = k;
        head.next = tail;
        tail.pre = head;
        // write code here
        int resultLen = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int resultIndex = 0;
        int[] result = new int[resultLen];
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                result[resultIndex++] = get(operators[i][1]);
            }
        }
        return result;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            // 移动node前，前把node的前后处理了
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (get(key) > -1) {
            map.get(key).value = value;
        } else {
            if (map.size() == cap) {
                int delKey = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(delKey);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
