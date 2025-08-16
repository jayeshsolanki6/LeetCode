class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int can = image[sr][sc];
        image[sr][sc] = color;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int[][] visited = new int[m][n];

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int[] curr = queue.remove();
                int i = curr[0];
                int j = curr[1];
                for(int[] dir : direction){
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && jj >= 0 && ii < m && jj < n && visited[ii][jj] == 0 && image[ii][jj] == can){
                        image[ii][jj] = color;
                        visited[ii][jj] = 1;
                        queue.add(new int[]{ii, jj});
                    }
                }
            }
        }
        return image;
    }
}