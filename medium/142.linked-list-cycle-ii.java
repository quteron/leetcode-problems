ListNode node = intersection(head);
    if (node == null) {
        return null;
    }

    while(head != node) {
        head = head.next;
        node = node.next;
    }

    return node;
}

private ListNode intersection(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return fast;
        }
    }

    return null;
}
