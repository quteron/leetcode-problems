public ListNode middleNode(ListNode head) {
    ListNode tail = head;
    while (tail != null && tail.next != null) {
        head = head.next;
        tail = tail.next.next;
    }

    return head;
}
