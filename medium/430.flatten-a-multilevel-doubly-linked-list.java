public Node flatten(Node head) {
    Node dummy = new Node();
    dummy.next = head;

    flattenRecursive(dummy);
    return head;
}

public Node flattenRecursive(Node head) {
    while (head.next != null) {
        head = head.next;
        if (head.child != null) {
            Node next = head.next;

            head.next = head.child;
            head.next.prev = head;
            head.child = null;

            Node last = flattenRecursive(head);
            if (next != null) {
                last.next = next;
                next.prev = last;
            }

            head = last;
        }
    }

    return head;
}
