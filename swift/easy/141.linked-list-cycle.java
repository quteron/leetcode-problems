public boolean hasCycle(ListNode head) {
    ListNode tail = head;

    while (tail != null && tail.next != null) {
        head = head.next;
        tail = tail.next.next;

        if (head == tail) {
            return true;
        }
    }

    return false;
}
