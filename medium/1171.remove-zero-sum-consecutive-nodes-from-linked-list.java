public ListNode removeZeroSumSublists(ListNode head) {
    if (head == null) {
        return null;
    }

    HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    ListNode dummy = new ListNode(0, head);

    int sum = 0;
    ListNode current = dummy;
    while (current != null) {
        sum +=current.val;
        map.put(sum, current);
        current = current.next;
    }

    sum = 0;
    current = dummy;
    while (current != null) {
        sum +=current.val;
        current.next = map.get(sum).next;
        current = current.next;
    }

    return dummy.next;
}
