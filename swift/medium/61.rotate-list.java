public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
        return head;
    }

    // calculate the size of the list
    int size = 1;
    ListNode current = head;
    while (current.next != null) {
        current = current.next;
        size++;
    }

    // make the cycle, the ring
    current.next = head;
    // calculate new end of the list
    k = size - (k % size);

    current = head;
    while (k != 1) {
        k--;
        current = current.next;
    }

    // set new head
    head = current.next;
    // break the ring
    current.next = null;

    return head;
}
