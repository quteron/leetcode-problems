public int[] maxSlidingWindow(int[] nums, int k) {
    int[] output = new int[nums.length-k+1];
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> nums[b]-nums[a]);

    for (int i=0; i<k-1; i++) {
        queue.offer(i);
    }

    int l = 0, r = k-1;
    while (r < nums.length) {
        queue.offer(r++);

        while (queue.peek() < l) {
            queue.poll();
        }

        output[l++] = nums[queue.peek()];
    }

    return output;
}
