public int[] nextLargerNodes(ListNode head) {
    ArrayList<Integer> values = new ArrayList<Integer>();

    ListNode current = head;
    while(current != null) {
        values.add(current.val);
        current = current.next;
    }

    int[] output = new int[values.size()];
    Deque<Integer> stack = new ArrayDeque<Integer>();

    for(int i=0; i<values.size(); i++) {
        while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
            output[stack.pop()] = values.get(i);
        }
        stack.push(i);
    }

    return output;
}
