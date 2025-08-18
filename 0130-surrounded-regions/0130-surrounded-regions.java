class Solution {
    int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && (board[i][j] == 'O')){
                    dfs(i, j, board);
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'Z'){
                    board[i][j] = 'O';
                }

            }
        }
        
    }
    void dfs(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }
        if(board[i][j] == 'X' || board[i][j] == 'Z') return;
        board[i][j] = 'Z';
        dfs(i, j-1, board);
        dfs(i, j+1, board);
        dfs(i-1, j, board);
        dfs(i+1, j, board);
    }
}