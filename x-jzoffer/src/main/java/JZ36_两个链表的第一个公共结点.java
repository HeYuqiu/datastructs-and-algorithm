import java.util.HashSet;

/**
 * 题目描述 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 
 * @author Yuqiu.He
 * @date 2021/3/15
 */
public class JZ36_两个链表的第一个公共结点 {
    // 利用java自带的数据结构，不是面试官想要的
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> list = new HashSet<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            list.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (list.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }

    // 流弊：将两个链表相互拼接，使其长度一样，如果存在公共节点，那末尾一定一样
    public ListNode FindFirstCommonNode_optimaze(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) { // 终结条件：两遍轮询完了，两个都等于null
                if (p1 == null)
                    p1 = pHead2;
                if (p2 == null)
                    p2 = pHead1;
            }
        }
        return p1;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
