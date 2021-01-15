public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode();
    ListNode current = head;

    while (current != null) {
        ListNode sorted = dummy;
        while (sorted.next != null && sorted.next.val <= current.val) {
            sorted = sorted.next;
        }

        ListNode next = current.next;
        current.next = sorted.next;
        sorted.next = current;

        current = next;
    }

    return dummy.next;
}
