public int nthSuperUglyNumber(int n, int[] primes) {
    PriorityQueue<Long> queue = new PriorityQueue<>();
    queue.add(1L);

    while (n-- > 1) {
        long current = queue.peek();
        while (!queue.isEmpty() && queue.peek() == current) {
            queue.poll();
        }

        for (int prime : primes) {
            long next = current * prime;
            queue.add(next);
        }
    }

    long current = queue.poll();
    return (int) current;
}
