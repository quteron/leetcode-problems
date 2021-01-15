public ListNode sortList(ListNode head) {
    return mergeSort(head);
}

private ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    ListNode middle = findMiddleNode(head);
    ListNode tail = middle.next;
    middle.next = null;

    ListNode left = mergeSort(head);
    ListNode right = mergeSort(tail);
    return merge(left, right);
}

private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode();

    ListNode current = dummy;
    while (left != null && right != null) {
        if (left.val <= right.val) {
            current.next = left;
            left = left.next;
        } else {
            current.next = right;
            right = right.next;
        }

        current = current.next;
    }

    current.next = left != null ? left : right;
    return dummy.next;
}

private ListNode findMiddleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
