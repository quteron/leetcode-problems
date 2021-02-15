public List<Integer> minAvailableDuration(int[][] a, int[][] b, int d) {
    Arrays.sort(a, (a1,a2) -> a1[0]-a2[0]);
    Arrays.sort(b, (b1,b2) -> b1[0]-b2[0]);

    int i=0, j=0;
    while (i < a.length && j < b.length) {
       int lo = Math.max(a[i][0], b[j][0]);
       int hi = Math.min(a[i][1], b[j][1]);

        if (lo <= hi && hi-lo >= d) {
            return Arrays.asList(lo, lo+d);
        }

        if (a[i][1] > b[j][1]) {
            j++;
        } else {
            i++;
        }
    }

    return new ArrayList();
}
