public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode left = dummy;

    int pos = 1;
    while (pos < m) {
        left = left.next;
        pos++;
    }

    head = left.next;
    ListNode tail = null;
    ListNode right = left.next;

    while (pos <= n) {
        ListNode next = right.next;
        right.next = tail;
        tail = right;
        right = next;
        pos++;
    }

    left.next = tail;
    head.next = right;

    return dummy.next;
}
