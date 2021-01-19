import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 输入 {67,0,24,58}
 *
 * 返回值 [58,24,0,67]
 * 
 * @author Yuqiu.He
 * @date 2021/1/19
 */
public class JZ3_从头到尾打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            result.add(listNode.val);
            while (listNode.next != null) {
                result.add(0, listNode.next.val);
                listNode = listNode.next;
            }
        }
        return result;
    }

    public ArrayList<Integer> printListFromTailToHead_stack(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            Stack<Integer> stack = new Stack<>();
            stack.push(listNode.val);
            while (listNode.next != null) {
                stack.push(listNode.next.val);
                listNode = listNode.next;
            }
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
