class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res[][] = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    res[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else{
                    res[i][j] = -1;
                }
            }
        }
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] curr = queue.remove();
                int i = curr[0];
                int j = curr[1];
                for(int[] dir : direction){
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && jj >=0 && ii < m && jj < n && res[ii][jj] == -1){
                        res[ii][jj] = res[i][j] + 1;
                        queue.add(new int[]{ii, jj});
                    }
                }
            }
        }
        return res;
    } 
}