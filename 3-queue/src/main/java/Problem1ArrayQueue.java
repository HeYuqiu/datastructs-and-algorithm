/**
 * 用数组实现的队列
 *
 * @author Yuqiu.He
 * @date 2020-06-28
 */
public class Problem1ArrayQueue {
    private String[] items;
    private int head;
    private int tail;
    private final int capacity;

    public Problem1ArrayQueue(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    /**
     * 入列
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 如果tail == n 表示队列已经满了
        if (tail == capacity) {
            return false;
        }
        items[tail++] = item;
        return true;
    }

    /**
     * 出列
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        return items[head++];
    }

    public static void main(String[] args) {
        Problem1ArrayQueue stack = new Problem1ArrayQueue(5);
        stack.enqueue("1");
        stack.enqueue("2");
        stack.enqueue("3");
        System.out.println(stack.dequeue());
        stack.enqueue("4");
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        System.out.println(stack.dequeue());
        stack.enqueue("5");
        stack.enqueue("6");
    }
}
