public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);

    ListNode slow = dummy;
    ListNode fast = dummy;

    while (n != 0) {
        n--;
        fast = fast.next;
    }

    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }

    slow.next = slow.next.next;

    return dummy.next;
}
