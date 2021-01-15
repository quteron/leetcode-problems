public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode current = dummy;

    while (current.next != null) {
        ListNode prev = current;
        ListNode tail = prev.next;

        int count = 0;
        while (current.next != null && count != k) {
            current = current.next;
            count++;
        }

        if (count != k) {
            break;
        }

        ListNode next = current.next;
        current.next = null;
        prev.next = reverse(prev.next);
        tail.next = next;
        current = tail;
    }

    return dummy.next;
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
