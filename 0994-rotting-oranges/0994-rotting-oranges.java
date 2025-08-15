class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;
        int freshOranges = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }

        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!queue.isEmpty() && freshOranges > 0){
            int size = queue.size();
            while(size-- > 0){
                int[] curr = queue.remove();
                int i = curr[0];
                int j = curr[1];
                for(int[] dir : direction){
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && jj >= 0 && ii < m && jj < n && grid[ii][jj] == 1){
                        queue.add(new int[]{ii, jj});
                        grid[ii][jj] = 2;
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        if(freshOranges > 0){
            return -1;
        }
        return time;
    }
}