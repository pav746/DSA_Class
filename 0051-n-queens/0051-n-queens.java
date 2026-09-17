class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols=new HashSet<>();
        Set<Integer> diag1=new HashSet<>();
        Set<Integer> diag2=new HashSet<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
            
        }
        backtrack(0,n,board,cols,diag1,diag2);
        return result;


    }
    private void backtrack(int row, int n, char[][] board, Set<Integer> cols,Set<Integer> diag1, Set<Integer> diag2){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(char[] r: board){
                temp.add(new String(r));
            }
            result.add(temp);
            return;
        }
         for(int col=0; col<n; col++){

            if(cols.contains(col) ||
               diag1.contains(row-col) ||
               diag2.contains(row+col))
                continue;

            board[row][col] = 'Q';

            cols.add(col);
            diag1.add(row-col);
            diag2.add(row+col);

            backtrack(row+1, n, board, cols, diag1, diag2);

            board[row][col] = '.';

            cols.remove(col);
            diag1.remove(row-col);
            diag2.remove(row+col);
        }
    }
}