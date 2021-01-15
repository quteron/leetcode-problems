public ListNode swapNodes(ListNode head, int k) {
    ListNode current = head;

    // find front
    while (k != 1) {
        current = current.next;
        k--;
    }
    ListNode front = current;

    // find back
    ListNode back = head;
    while (current.next != null) {
        back = back.next;
        current = current.next;
    }

    // swap values
    int val = back.val;
    back.val = front.val;
    front.val = val;

    return head;
}
