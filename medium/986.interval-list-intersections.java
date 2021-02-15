public int[][] intervalIntersection(int[][] a, int[][] b) {
    List<int[]> ans = new ArrayList();

    int i=0, j=0;
    while (i<a.length && j<b.length) {
        int lo = Math.max(a[i][0], b[j][0]);
        int hi = Math.min(a[i][1], b[j][1]);

        if (lo<=hi) {
            ans.add(new int[] {lo, hi});
        }

        if (a[i][1] > b[j][1]) {
            j++;
        } else {
            i++;
        }
    }

    return ans.toArray(new int[ans.size()][]);
}
