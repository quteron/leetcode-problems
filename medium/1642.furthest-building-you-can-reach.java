public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> allocatedLadders = new PriorityQueue<>();

    for (int i=0; i<heights.length-1; i++) {
        int climb = heights[i+1] - heights[i];
        // jump down
        if (climb <= 0) {
            continue;
        }

        // have enough ladders - use ladder
        allocatedLadders.add(climb);
        if (allocatedLadders.size() <= ladders) {
            continue;
        }

        // have not enough ladders - try to use bricks
        bricks -= allocatedLadders.poll();
        if (bricks < 0) {
            return i;
        }
    }

    return heights.length - 1;
}
