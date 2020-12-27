public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0, head);

    ListNode current = dummy;
    while (current.next != null) {
        int i = 0;
        while (current.next != null && i != m) {
            current = current.next;
            i++;
        }

        i = 0;
        while (current.next != null && i != n) {
            current.next = current.next.next;
            i++;
        }
    }

    return dummy.next;
}
