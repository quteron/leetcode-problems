class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> skipped = new PriorityQueue<>((a,b) -> b-a);

        int refuel = 0;
        int current = startFuel;

        for (int[] station : stations) {
            while (!skipped.isEmpty() && current < station[0]) {
                refuel++;
                current += skipped.poll();
            }

            if (current < station[0] || current >= target) {
                break;
            }

            skipped.offer(station[1]);
        }

        while (!skipped.isEmpty() && current < target) {
            refuel++;
            current += skipped.poll();
        }

        return current >= target ? refuel : -1;
    }
}
