public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode dummy = new ListNode(0, list1);

    ListNode current = dummy;
    while (a != 0) {
        current = current.next;
        a--;
        b--;
    }

    ListNode prev = current;
    current = current.next;

    prev.next = list2;
    while (prev.next != null) {
        prev = prev.next;
    }

    while (b != 0) {
        current = current.next;
        b--;
    }

    prev.next = current.next;
    return dummy.next;
}
