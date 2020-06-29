import model.ListNode;

/**
 * 链表的中间结点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * LeetCode:876
 *
 * @author Yuqiu.He
 * @date 2020-06-24
 */
public class Problem5MiddleNode {
    public static void main(String[] args) {
        ListNode head = ListNode.init();
        ListNode middle = middleNode(head);
        System.out.println(middle.value);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode currSlow = head;
        ListNode currFast = head;
        while (currFast != null && currFast.next != null) {
            currSlow = currSlow.next;
            currFast = currFast.next.next;
        }
        return currSlow;
    }
}
