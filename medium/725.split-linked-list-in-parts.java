public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] parts = new ListNode[k];

    int totalSize = getSize(root);
    int partSize = totalSize / k;
    int carry = totalSize % k;

    for (int i=0; i<k; i++) {
        int size = partSize + (i < carry ? 1 : 0);
        ListNode part = new ListNode(0);
        ListNode current = part;

        while (size != 0) {
            current.next = root;
            size--;

            current = current.next;
            root = root.next;
        }

        current.next = null;
        parts[i] = part.next;
    }

    return parts;
}

private int getSize(ListNode root) {
    int size = 0;
    while (root != null) {
        root = root.next;
        size++;
    }
    return size;
}
