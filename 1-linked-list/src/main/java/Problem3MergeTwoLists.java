import com.alibaba.fastjson.JSON;
import model.ListNode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * LeetCode:21
 *
 * @author Yuqiu.He
 * @date 2020-06-24
 */
public class Problem3MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.init();
        ListNode l2 = ListNode.init();
        ListNode merge = mergeTwoLists_digui(l1, l2);
        System.out.println(JSON.toJSON(merge));
    }

    /**
     * 递归实现
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_digui(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.value < l2.value) {
            l1.next = mergeTwoLists_digui(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_digui(l1, l2.next);
            return l2;
        }
    }
}
