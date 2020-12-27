public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB = headB;

    while (curA != curB) {
        curA = curA == null ? headB : curA.next;
        curB = curB == null ? headA : curB.next;

    }

    return curA;
}
