class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n, len;
    String word;
    char[][] board;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        len = word.length();

        char c = word.charAt(0);
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == c){
                    if(helper(i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean helper(int i, int j, int ind){
        if(ind == len) return true;

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(ind) || board[i][j] == '!'){
            return false;
        }

        char c = board[i][j];
        board[i][j] = '!';

        // boolean res = false;
        // for(int k = 0; k<4; k++){
        //     int[] d = dir[i];
        //     int ni = i+d[0];
        //     int nj = j+d[1];
        //     res = res || helper(ni, nj, ind+1);
        // }

        boolean top = helper(i - 1, j, ind + 1);
        boolean right = helper(i, j + 1, ind + 1);
        boolean bottom = helper(i + 1, j, ind + 1);
        boolean left = helper(i, j - 1, ind + 1);
        board[i][j] = c;
        // return res;
        return top || right || bottom || left;
    }
}