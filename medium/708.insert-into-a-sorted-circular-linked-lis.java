public Node insert(Node head, int insertVal) {
    if (head == null) {
        head = new Node(insertVal);
        head.next = head;
        return head;
    }

    Node current = head.next;
    // repeat until go on the second round
    while (current != head) {
        int val = current.val;
        int next = current.next.val;

        // first or last
        if (next < val) {
            // if to be added first
            if (next > insertVal && val > insertVal) {
                break;
            }

            // if to be added last
            if (next < insertVal && val < insertVal) {
                break;
            }
        } else if (val <= insertVal && insertVal <= next) {
            break;
        }

        current = current.next;
    }

    // insert new node
    Node node = new Node(insertVal);
    node.next = current.next;
    current.next = node;

    return head;
}
