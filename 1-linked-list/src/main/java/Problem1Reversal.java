import com.alibaba.fastjson.JSON;
import model.ListNode;

/**
 * 单链表反转
 * leetCode:206
 *
 * @author Yuqiu.He
 * @date 2020-06-22
 */
public class Problem1Reversal {
    public static void main(String[] args) {
        ListNode head = ListNode.init();
        System.out.println(JSON.toJSONString(head));
        ListNode prev = reversal(head);
        System.out.println(JSON.toJSONString(prev));
    }

    public static ListNode reversal(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
