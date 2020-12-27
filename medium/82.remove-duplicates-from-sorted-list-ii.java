public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0, head);

    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        if (current.next.val == current.next.next.val) {
            int val = current.next.val;
            while (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            }
        } else {
            current = current.next;
        }
    }

    return dummy.next;
}
