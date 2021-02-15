public int minTimeToVisitAllPoints(int[][] points) {
    int time = 0;

    for (int i=1; i<points.length; i++) {
        int[] prev = points[i-1];
        int[] next = points[i];

        int dx = Math.abs(prev[0]-next[0]);
        int dy = Math.abs(prev[1]-next[1]);

        time += Math.max(dx, dy);
    }

    return time;
}
