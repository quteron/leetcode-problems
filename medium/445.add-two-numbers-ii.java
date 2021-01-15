public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode rl1 = reverse(l1);
    ListNode rl2 = reverse(l2);

    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    int carry = 0;
    while (rl1 != null || rl2 != null) {
        int v1 = rl1 != null ? rl1.val : 0;
        int v2 = rl2 != null ? rl2.val : 0;
        int sum = v1 + v2 + carry;

        current.next = new ListNode(sum % 10);
        current = current.next;

        carry = sum / 10;

        rl1 = rl1 != null ? rl1.next : null;
        rl2 = rl2 != null ? rl2.next : null;
    }

    if (carry != 0) {
        current.next = new ListNode(carry);
    }

    return reverse(dummy.next);
}

private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
