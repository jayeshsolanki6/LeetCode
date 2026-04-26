class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int time = 0;
        while(!q.isEmpty() && fresh > 0){
            time++;
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] pair = q.remove();
                for(int[] d : dir){
                    int x = pair[0] + d[0];
                    int y = pair[1] + d[1];
                    if(x < 0 || y < 0 || x >= m || y >= n) continue;
                    if(grid[x][y] == 1){
                        q.add(new int[]{x, y});
                        grid[x][y] = 2;
                        fresh--;
                    }
                }
            }
        }
        if(fresh > 0) return -1;
        return time;
    }
}