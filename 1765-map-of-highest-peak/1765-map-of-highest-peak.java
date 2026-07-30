class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(isWater[i][j] == 1){
                    q.add(new int[]{i, j});
                    isWater[i][j] = -1;
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            int[] pair = q.remove();
            int x = pair[0], y = pair[1];
            int temp = (isWater[x][y] == -1) ? 1 : isWater[x][y]+1;
            for(int[] d : dir){
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && isWater[nx][ny] == 0){
                    isWater[nx][ny] = temp;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(isWater[i][j] == -1){
                    isWater[i][j] = 0;
                }
            }
        }

        return isWater;
    }
}