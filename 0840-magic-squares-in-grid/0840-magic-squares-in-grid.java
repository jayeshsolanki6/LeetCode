class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m < 3 || n < 3) return 0;
        int count = 0;
        for(int i = 0; i<=m-3; i++){
            for(int j = 0; j<=n-3; j++){
                if(isValid(i, j, grid)){
                    count++;
                }
            }
        }
        return count;
    }
    boolean isValid(int m, int n, int[][] grid){
        int a = 0, b = 0, c = 0;
        int x = 0, y = 0;
        for(int i = 0; i<3; i++){
            int sum = 0;
            for(int j = 0; j<3; j++){
               int val = grid[i+m][j+n];
               sum += val;
               if(j == 0) a += val;
               else if(j == 1) b += val;
               else c += val;

               if(i == j) x += val;
               if(i+j == 2) y += val; 
            }
            if(sum != 15) return false;
        }
        if(a != 15 || b != 15 || c != 15 || x != 15 || y != 15) return false;
        return true;
    }

}