class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        int n = grid.length;

        if(n == 1 && grid[0][0] == 0) return 1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});

        while(!q.isEmpty()){
            int[] pair = q.remove();
            int i = pair[0], j = pair[1], len = pair[2];
            for(int x = -1; x <= 1; x++){
                for(int y = -1; y <= 1; y++){
                    if(x == 0 && y == 0) continue;
                    int a = i+x, b = j+y;
                    if(a >= 0 && b >= 0 && a < n && b < n && grid[a][b] == 0){
                        if(a == n-1 && b == n-1) return len+1;
                        grid[a][b] = 2;
                        q.add(new int[]{a, b, len+1});
                    }
                }
            }
        }

        return -1;
    }
}