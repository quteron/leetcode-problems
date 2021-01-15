public int numComponents(ListNode head, int[] G) {
    int count = 0;

    Set<Integer> set = new HashSet();
    for(int n : G) {
        set.add(n);
    }

    while (head != null && !set.isEmpty()) {
        if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
            count++;
        }

        head = head.next;
    }

    return count;
}
