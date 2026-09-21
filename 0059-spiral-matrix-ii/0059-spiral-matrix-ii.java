class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int t = 0, b = n-1;
        int l = 0, r = n-1;
        int s = 1;
        while(t <= b && l <= r){
            for(int j = l; j<=r; j++){
                res[t][j] = s++;
            }
            t++;
            for(int i = t; i<=b; i++){
                res[i][r] = s++;
            }
            r--;
            for(int j = r; j>=l; j--){
                res[b][j] = s++;
            }
            b--;
            for(int i = b; i>=t; i--){
                res[i][l] = s++;
            }
            l++;
        }
        return res;
    }
}