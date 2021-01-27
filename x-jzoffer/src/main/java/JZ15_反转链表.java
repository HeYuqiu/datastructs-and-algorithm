/**
 * @author Yuqiu.He
 * @date 2021/1/27
 */
public class JZ15_反转链表 {
    public ListNode ReverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
