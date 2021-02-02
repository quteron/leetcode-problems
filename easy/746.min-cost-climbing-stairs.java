public int minCostClimbingStairs(int[] cost) {
    int one = cost[0];
    int two = cost[1];

    for (int i=2; i<cost.length; i++) {
        int cur = cost[i] + Math.min(one, two);
        one = two;
        two = cur;
    }

    return Math.min(one, two);
}
