class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for(int[] query : queries){
            int r1 = query[0], c1 = query[1];
            int r2 = query[2], c2 = query[3];
            mat[r1][c1]++;
            if(c2 < n-1) mat[r1][c2+1]--;
            if(r2 < n-1) mat[r2+1][c1]--;
            if(r2 < n-1 && c2 < n-1) mat[r2+1][c2+1]++;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                int x1 = (i == 0) ? 0 : mat[i-1][j];
                int x2 = (j == 0) ? 0 : mat[i][j-1];
                int x3 = (i == 0 || j == 0) ? 0 : mat[i-1][j-1];
                mat[i][j] += x1 + x2 - x3;
            }
        }
        return mat;
    }
}