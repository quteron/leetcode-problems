public ListNode plusOne(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode notNine = dummy;

    while (head != null) {
        if (head.val != 9) {
            notNine = head;
        }
        head = head.next;
    }

    notNine.val += 1;

    while (notNine.next != null) {
        notNine.next.val = 0;
        notNine = notNine.next;
    }

    return dummy.val == 0 ? dummy.next : dummy;
}
