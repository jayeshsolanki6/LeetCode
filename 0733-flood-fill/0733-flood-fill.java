class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dfs(sr, sc, color, image[sr][sc], image, dir);
        return image;
    }
    void dfs(int x, int y, int c, int pc, int[][] image, int[][] dir){
        image[x][y] = c;

        for(int[] d : dir){
            int i = x + d[0], j = y + d[1];
            if(i >= 0 && j >= 0 && i < image.length && j < image[0].length && image[i][j] == pc){
                dfs(i, j, c, pc, image, dir);
            }
        }
    }
}