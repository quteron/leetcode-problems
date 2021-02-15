public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int number = 1;
    int d = 0, row = 0, col = 0;

    while (number <= n*n) {
        matrix[row][col] = number++;

        int r = Math.floorMod(row + dir[d][0], n);
        int c = Math.floorMod(col + dir[d][1], n);

        if (matrix[r][c] != 0) {
            d = (d+1)%4;
        }

        row += dir[d][0];
        col += dir[d][1];
    }

    return matrix;
}
