class Solution {

    public int eatenApples(int[] apples, int[] days) {
        // expiry day -> apples
        Map<Integer, Integer> expiry = new HashMap<>();
        // expiry day
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int count = 0;
        for (int i=0; i<apples.length || !queue.isEmpty(); i++) {
            // put new apples
            if (i < apples.length && apples[i] != 0) {
                int currentExpiry = i + days[i];
                if (!expiry.containsKey(currentExpiry)) {
                    queue.add(currentExpiry);
                }

                int currentApples = expiry.getOrDefault(currentExpiry, 0);
                expiry.put(currentExpiry, currentApples + apples[i]);
            }

            // remove all rotten apples
            while (!queue.isEmpty() && queue.peek() <= i) {
                queue.poll();
            }

            // eat an apple
            if (!queue.isEmpty()) {
                int expiryDay = queue.peek();
                count++;

                int applesCount = expiry.get(expiryDay);
                if (applesCount > 1) {
                    expiry.put(expiryDay, applesCount-1);
                } else {
                    queue.poll();
                    expiry.remove(expiryDay);
                }

            }
        }

        return count;
    }
}
