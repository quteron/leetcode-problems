class Solution {
    public void setZeroes(int[][] matrix) {
        int row1 = 1;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length;j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        row1 = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowZeros(matrix, i);
            }
        }

        for (int j=0; j<matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                setColumnZeros(matrix, j);
            }
        }

        if (row1 == 0) {
            setRowZeros(matrix, 0);
        }
    }

    private void setColumnZeros(int[][] matrix, int j) {
        for (int k=0; k<matrix.length; k++) {
            matrix[k][j] = 0;
        }
    }

    private void setRowZeros(int[][] matrix, int i) {
        for (int k=0; k<matrix[i].length; k++) {
            matrix[i][k] = 0;
        }
    }
}
