class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
            if (!isValidCol(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                if (used[board[row][i] - '1']) {
                    return false;
                }
                used[board[row][i] - '1'] = true;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                if (used[board[i][col] - '1']) {
                    return false;
                }
                used[board[i][col] - '1'] = true;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int row, int col) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[row + i][col + j] != '.') {
                    if (used[board[row + i][col + j] - '1']) {
                        return false;
                    }
                    used[board[row + i][col + j] - '1'] = true;
                }
            }
        }
        return true;
    }
}
