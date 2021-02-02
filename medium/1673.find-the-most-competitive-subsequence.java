public int[] mostCompetitive(int[] nums, int k) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i=0; i<nums.length; i++) {
        while (!stack.isEmpty() && stack.peek() > nums[i] && stack.size() + nums.length-i > k) {
            stack.pop();
        }

        if (stack.size() != k) {
            stack.push(nums[i]);
        }
    }

    int[] output = new int[k];
    while (!stack.isEmpty()) {
        output[--k] = stack.pop();
    }

    return output;
}
