class Solution {

    private int solve(int n, int col, char[][] board,int[] visitedRow, int[] lowerDiagonal,int[] upperDiagonal, int ans) {
        if (col == n) {
            return ans + 1;
        }
        for (int row = 0; row < n; row++) {
            if (visitedRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - row + col - 1] == 0) {
                board[row][col] = 'Q';
                visitedRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - row + col - 1] = 1;
                ans = solve(n, col + 1, board,
                            visitedRow, lowerDiagonal,
                            upperDiagonal, ans);

                board[row][col] = '.';

                visitedRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - row + col - 1] = 0;
            }
        }

        return ans;
    }

    public int totalNQueens(int n) {
        int ans = 0;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        int[] visitedRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];

        ans = solve(n, 0, board, visitedRow,
                    lowerDiagonal, upperDiagonal, ans);
        return ans;
    }
}