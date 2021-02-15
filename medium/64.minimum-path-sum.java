public int minPathSum(int[][] grid) {
    int[] sum = new int[grid[0].length];

    for (int i=0; i<grid.length; i++) {
        for (int j=0; j<grid[i].length; j++) {
            if (j == 0) {
                sum[j] += grid[i][j];
            } else if (i == 0) {
                sum[j] = sum[j-1] + grid[i][j];
            } else {
                sum[j] = Math.min(sum[j-1] + grid[i][j], sum[j] + grid[i][j]);
            }
        }
    }

    return sum[sum.length-1];
}
