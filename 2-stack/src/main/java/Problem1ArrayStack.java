/**
 * 用数组实现栈
 *
 * @author Yuqiu.He
 * @date 2020-06-28
 */
public class Problem1ArrayStack {
    // 数组
    private String[] items;
    // 栈中元素的个数
    private int count;
    // 栈的大小
    private final int capacity;

    public Problem1ArrayStack(int capacity) {
        items = new String[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 入栈
     *
     * @param item
     */
    public boolean push(String item) {
        if (count >= capacity) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public String pop() {
        if (count == 0) {
            return null;
        }
        return items[--count];
    }

    public static void main(String[] args) {
        Problem1ArrayStack stack = new Problem1ArrayStack(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        stack.push("4");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
