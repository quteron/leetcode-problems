// recursion
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
}

public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null) {
        return carry > 0 ? new ListNode(carry) : null;
    }

    int a = l1 != null ? l1.val : 0;
    int b = l2 != null ? l2.val : 0;
    int sum = a + b + carry;

    ListNode node = new ListNode(sum % 10);

    l1 = l1 != null ? l1.next : null;
    l2 = l2 != null ? l2.next : null;
    node.next = addTwoNumbers(l1, l2, sum / 10);
    return node;
}

// iteration
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (l1 != null || l2 != null) {
        int a = l1 != null ? l1.val : 0;
        int b = l2 != null ? l2.val : 0;

        int sum = a + b + carry;
        current.next = new ListNode(sum % 10);
        carry = sum / 10;

        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
        current = current.next;
    }

    if (carry > 0) {
        current.next = new ListNode(carry);
    }

    return dummy.next;
}
