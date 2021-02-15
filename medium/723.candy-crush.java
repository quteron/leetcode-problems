class Solution {
    public int[][] candyCrush(int[][] board) {
        if (crush(board)) {
            gravity(board);
            return candyCrush(board);
        }

        return board;
    }

    private boolean crush(int[][] board) {
        boolean crushed = false;

        // row by row
        for (int r=0; r<board.length; r++) {
            for (int c=0; c+2<board[0].length; c++) {
                int value = Math.abs(board[r][c]);
                if (value != 0 && Math.abs(board[r][c]) == Math.abs(board[r][c+1]) && Math.abs(board[r][c+1]) == Math.abs(board[r][c+2])) {
                    board[r][c] = -value;
                    board[r][c+1] = -value;
                    board[r][c+2] = -value;

                    crushed = true;
                }
            }
        }

        // column by column
        for (int r=0; r+2<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                int value = Math.abs(board[r][c]);
                if (value != 0 && Math.abs(board[r][c]) == Math.abs(board[r+1][c]) && Math.abs(board[r+1][c]) == Math.abs(board[r+2][c])) {
                    board[r][c] = -value;
                    board[r+1][c] = -value;
                    board[r+2][c] = -value;

                    crushed = true;
                }
            }
        }

        return crushed;
    }

    private void gravity(int[][] board) {
        for (int c=0; c<board[0].length; c++) {
            int latestNotNegativeRow = board.length-1;
            for (int r=board.length-1; r>=0; r--) {
                if (board[r][c] > 0) {
                    board[latestNotNegativeRow--][c] = board[r][c];
                }
            }

            while (latestNotNegativeRow >= 0) {
                board[latestNotNegativeRow--][c] = 0;
            }
        }
    }
}
