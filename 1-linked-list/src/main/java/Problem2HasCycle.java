import model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表中环的检测
 * LeetCode:141
 *
 * @author Yuqiu.He
 * @date 2020-06-24
 */
public class Problem2HasCycle {

    public static void main(String[] args) {
        System.out.println(hasCycle(ListNode.init()));
        System.out.println(hasCycle(ListNode.initCycle()));
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (!nodesSeen.add(curr)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }
}
