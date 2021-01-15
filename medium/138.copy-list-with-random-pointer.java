public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }

    Node current = head;
    while (current != null) {
        Node next = current.next;
        current.next = new Node(current.val);
        current.next.next = next;
        current = next;
    }

    current = head;
    while (current != null) {
        if (current.random != null) {
            current.next.random = current.random.next;
        }
        current = current.next.next;
    }

    Node dummy = new Node(0);
    Node copied = dummy;

    current = head;
    while (current != null) {
        copied.next = current.next;
        copied = copied.next;

        current.next = current.next.next;
        current = current.next;
    }

    return dummy.next;
}
