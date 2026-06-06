class Solution {
    class Pair{
        int x, y, obs, d;
        Pair(int x, int y, int obs, int d){
            this.x = x;
            this.y = y;
            this.obs = obs;
            this.d = d;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        for(int[] v: vis){
            Arrays.fill(v, -1);
        }
        vis[0][0] = k;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0,k,0));

        int[][] dis = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x, y = p.y, obs = p.obs, d = p.d;

            if(x == m-1 && y == n-1) return d;

            for(int[] di : dis){
                int nx = x + di[0];
                int ny = y + di[1];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int nobs = obs - grid[nx][ny];
                if(nobs == -1) continue;
                if(vis[nx][ny] >= nobs) continue;
                vis[nx][ny] = nobs;
                q.add(new Pair(nx, ny, nobs, d+1));
            }
        }

        return -1;
    }
}