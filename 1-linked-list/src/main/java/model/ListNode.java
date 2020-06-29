package model;

/**
 * 单向链表
 *
 * @author Yuqiu.He
 * @date 2020-06-22
 */
@SuppressWarnings("all")
public class ListNode {
    public ListNode next;
    public int value;

    public static ListNode init() {
        ListNode six = new ListNode();
        six.value = 6;
        ListNode five = new ListNode();
        five.value = 5;
        five.next = six;
        ListNode four = new ListNode();
        four.next = five;
        four.value = 4;
        ListNode three = new ListNode();
        three.next = four;
        three.value = 3;
        ListNode two = new ListNode();
        two.next = three;
        two.value = 2;
        ListNode head = new ListNode();
        head.next = two;
        head.value = 1;
        return head;
    }

    public static ListNode initCycle() {
        ListNode tail = new ListNode();
        tail.value = 5;
        ListNode four = new ListNode();
        four.next = tail;
        four.value = 4;
        ListNode three = new ListNode();
        three.next = four;
        three.value = 3;
        ListNode two = new ListNode();
        two.next = three;
        two.value = 2;
        ListNode head = new ListNode();
        head.next = two;
        head.value = 1;

        tail.next = two;
        return head;
    }
}
