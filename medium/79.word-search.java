class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (exist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int pos, int i, int j) {
        if (pos == word.length) {
            return true;
        }

        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
            return false;
        }

        if (word.charAt(pos) != board[i][j]) {
            return false;
        }

        char letter = board[i][j];
        board[i][j] = '0';

        boolean ans = exist(board, word, pos+1, i, j-1)
            || exist(board, word, pos+1, i, j+1)
            || exist(board, word, pos+1, i-1, j)
            || exist(board, word, pos+1, i+1, j);

        board[i][j] = letter;
        return ans;
    }
}
