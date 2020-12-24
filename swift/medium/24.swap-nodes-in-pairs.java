// recursion
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode newHead = head.next;
    head.next = swapPairs(newHead.next);
    newHead.next = head;

    return newHead;
}

// iteration
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode current = dummy;

    while (current.next != null && current.next.next != null) {
        ListNode ahead = current.next.next;
        current.next.next = current.next.next.next;
        ahead.next = current.next;
        current.next = ahead;

        current = current.next.next;
    }

    return dummy.next;
}
