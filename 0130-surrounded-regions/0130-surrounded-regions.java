class Solution {
    class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(n == 1 || m == 1) return;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int j = 0; j<n; j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board, dir, m, n);
            }
            if(board[m-1][j] == 'O'){
                dfs(m-1, j, board, dir, m, n);
            } 
        }
        for(int i = 1; i<m-1; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board, dir, m, n);
            }
            if(board[i][n-1] == 'O'){
                dfs(i, n-1, board, dir, m, n);
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
    void dfs(int i, int j, char[][] board, int[][] dir, int m, int n){
        board[i][j] = 'A';
        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || y < 0 || x >= m || y >= n) continue;
            if(board[x][y] == 'O'){
                dfs(x, y, board, dir, m, n);
            }
        }
    }
}