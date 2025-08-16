class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int can = image[sr][sc];
        // image[sr][sc] = color;
        // Queue<int[]> queue = new LinkedList<>();
        // queue.add(new int[]{sr, sc});
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        dfs(image, direction, sr, sc, color, can, m, n);
        // while(!queue.isEmpty()){
        //     int size = queue.size();
        //     while(size-- > 0){
        //         int[] curr = queue.remove();
        //         int i = curr[0];
        //         int j = curr[1];
        //         for(int[] dir : direction){
        //             int ii = i + dir[0];
        //             int jj = j + dir[1];
        //             if(ii >= 0 && jj >= 0 && ii < m && jj < n && image[ii][jj] == can && image[ii][jj] != color){
        //                 image[ii][jj] = color;
        //                 queue.add(new int[]{ii, jj});
        //             }
        //         }
        //     }
        // }
        return image;
    }
    void dfs(int[][] image, int[][] direction, int row, int col, int color, int can, int m, int n){
        image[row][col] = color;
        for(int[] dir : direction){
            int ii = row + dir[0];
            int jj = col + dir[1];
            if(ii >= 0 && jj >= 0 && ii < m && jj < n && image[ii][jj] == can && image[ii][jj] != color){
                dfs(image, direction, ii, jj, color, can, m, n);
            }
        }
    }
}