public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int lo = 0, hi = m*n-1;
    while (lo <= hi) {
        int mid = lo + (hi-lo)/2;
        int row = mid / n, column = mid % n;

        if (matrix[row][column] == target) {
            return true;
        } else if (matrix[row][column] > target) {
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }

    return false;
}
