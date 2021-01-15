public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode();

    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a, b) -> compare(a, b));
    for (ListNode list : lists) {
        if (list != null) {
            heap.add(list);
        }
    }

    ListNode current = dummy;
    while (!heap.isEmpty()) {
        ListNode node = heap.poll();
        current.next = node;
        current = current.next;

        if (node.next != null) {
            heap.add(node.next);
            current.next = null;
        }
    }

    return dummy.next;
}

private int compare(ListNode a, ListNode b) {
    return a.val - b.val;
}
