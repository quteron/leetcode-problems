public void reorderList(ListNode head) {
    if (head == null) {
        return;
    }

    // get middle node of the list
    ListNode middle = getMiddleNode(head);
    // revert the second part of the list
    ListNode second = reverse(middle.next);
    // cut the first part from the second part
    middle.next = null;
    // merge two parts
    head = merge(head, second);
}

public ListNode getMiddleNode(ListNode node) {
    ListNode slow = node;
    ListNode fast = node;

    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

public ListNode reverse(ListNode node) {
    ListNode prev = null;
    while (node != null) {
        ListNode next = node.next;
        node.next = prev;
        prev = node;
        node = next;
    }
    return prev;
}

public ListNode merge(ListNode first, ListNode second) {
    if (second == null) {
        return first;
    }

    second.next = merge(first.next, second.next);
    first.next = second;
    return first;
}
