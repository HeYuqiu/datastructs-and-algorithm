/**
 * 题目描述 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 示例1 输入 1,{1,2,3,4,5}
 *
 * 返回值 {5}
 * 
 * @author Yuqiu.He
 * @date 2021/1/26
 */
public class JZ14_链表中倒数第k个结点 {
    public static void main(String[] args) {
        JZ14_链表中倒数第k个结点 mian = new JZ14_链表中倒数第k个结点();
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;
        ListNode listNode = mian.FindKthToTail(list1, 1);
        System.out.println(listNode.val);
    }

    // 反转链表？不得行
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        while (--k > 0) {
            pre = pre.next;
        }
        return pre;
    }

    // 正确解法：快慢指针
    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
