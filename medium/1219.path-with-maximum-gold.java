class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                max = Math.max(max, getMaximumGold(grid, i, j));
            }
        }

        return max;
    }

    private int getMaximumGold(int[][] grid, int i, int j) {
        if (i<0 || j<0 || i==grid.length || j==grid[i].length) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        int current = grid[i][j];
        grid[i][j] = 0;

        int max = Math.max(0, getMaximumGold(grid, i-1, j));
        max = Math.max(max, getMaximumGold(grid, i+1, j));
        max = Math.max(max, getMaximumGold(grid, i, j-1));
        max = Math.max(max, getMaximumGold(grid, i, j+1));

        grid[i][j] = current;
        return max + current;
    }
}
