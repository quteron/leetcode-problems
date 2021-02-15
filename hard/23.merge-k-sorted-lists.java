public ListNode mergeKLists(ListNode[] lists) {
    ListNode dummy = new ListNode();

    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode node : lists) {
        if (node != null) {
            minHeap.offer(node);
        }
    }

    ListNode current = dummy;
    while (!minHeap.isEmpty()) {
        ListNode node = minHeap.poll();
        if (node.next != null) {
            minHeap.offer(node.next);
        }

        current.next = node;
        current = node;
    }

    return dummy.next;
}
