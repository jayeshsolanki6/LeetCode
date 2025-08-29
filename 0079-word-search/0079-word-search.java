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
                    if(helper(i, j, 0, -1, -1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean helper(int i, int j, int ind, int pi, int pj){
        if(ind == len) return true;
        if(board[i][j] != word.charAt(ind)) return false;
        if(ind == len-1) return true;
        for(int k = 0; k<4; k++){
            int[] d = dir[k];
            int ii = i + d[0];
            int jj = j + d[1];
            if(ii == pi && jj == pj) continue;
            if(ii >= 0 && ii < m && jj >= 0 && jj < n){
                if(helper(ii, jj, ind+1, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
}