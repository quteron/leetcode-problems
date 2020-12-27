public boolean isPalindrome(ListNode head) {
    ListNode first = head;

    ListNode middle = findMiddleNode(head);
    ListNode second = reverse(middle);

    while (first != null && second != null) {
        if (first.val != second.val) {
            return false;
        }

        first = first.next;
        second = second.next;
    }

    return true;
}

private ListNode findMiddleNode(ListNode head) {
    ListNode tail = head;

    while (tail != null && tail.next != null) {
        head = head.next;
        tail = tail.next.next;
    }

    return head;
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
