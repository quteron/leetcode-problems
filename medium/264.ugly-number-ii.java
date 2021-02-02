public int nthUglyNumber(int n) {
    int[] primes = new int[] {2, 3, 5};

    PriorityQueue<Long> queue = new PriorityQueue<>();
    queue.add(1L);

    while (n-- > 1) {
        long current = queue.peek();
        while (!queue.isEmpty() && queue.peek() == current) {
            queue.poll();
        }

        for (int prime : primes) {
            queue.add(current * prime);
        }
    }

    long number = queue.poll();
    return (int) number;
}
