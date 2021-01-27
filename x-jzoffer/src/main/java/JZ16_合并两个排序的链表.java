/**
 * 题目描述 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 示例1 输入 {1,3,5},{2,4,6}
 *
 * 返回值 {1,2,3,4,5,6}
 * 
 * @author Yuqiu.He
 * @date 2021/1/27
 */
public class JZ16_合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                temp.next = list2;
                break;
            } else if (list2 == null) {
                temp.next = list1;
                break;
            } else if (list1.val > list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
