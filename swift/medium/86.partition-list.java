public ListNode partition(ListNode head, int x) {
    ListNode before = new ListNode(0);
    ListNode after = new ListNode(0);

    ListNode curBefore = before;
    ListNode curAfter = after;
    while (head != null) {
        if (head.val >= x) {
            curAfter.next = head;
            curAfter = curAfter.next;
        } else if (head.val < x) {
            curBefore.next = head;
            curBefore = curBefore.next;
        }

        head = head.next;
    }


    curBefore.next = after.next;
    curAfter.next = null;

    return before.next;
}
