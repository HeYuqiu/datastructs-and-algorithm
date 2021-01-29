import java.util.Stack;

/**
 * 题目描述 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 * @author Yuqiu.He
 * @date 2021/1/29
 */
public class JZ20_包含min函数的栈 {
    Stack<Integer> total = new Stack<>();
    Stack<Integer> little = new Stack<>();

    public void push(int node) {
        total.push(node);
        if (little.isEmpty()) {
            little.push(node);
        } else {
            if (node < little.peek()) {
                little.push(node);
            } else {
                little.push(little.peek());
            }
        }
    }

    public void pop() {
        total.pop();
        little.pop();
    }

    public int top() {
        return total.peek();
    }

    public int min() {
        return little.peek();
    }
}
