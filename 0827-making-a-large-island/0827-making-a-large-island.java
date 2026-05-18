class Solution {
    int[] parent, size;
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        boolean[][] vis = new boolean[n][n];

        int len = n*n;
        parent = new int[len];
        for(int i = 0; i<len; i++) parent[i] = i;
        size = new int[len];
        Arrays.fill(size, 1);

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    int ind = n*i + j;
                    for(int[] d : dir){
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x < 0 || y < 0 || x >= n || y >= n) continue;
                        if(!vis[x][y]) continue;
                        int nind = x*n + y;
                        union(ind, nind);
                    }
                }
            }
        }
        int max = size[findUPar(0)];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == 0){
                    int land = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int[] d : dir){
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x < 0 || y < 0 || x >= n || y >= n) continue;
                        if(!vis[x][y]) continue;
                        int nind = x*n + y;
                        int par = findUPar(nind);
                        if(set.contains(par)) continue;
                        set.add(par);
                        land += size[par];
                    }
                    System.out.println(land);
                    max = Math.max(max, land);
                }
            }
        }
        return max;

    }
    int findUPar(int n){
        if(parent[n] == n) return n;
        return parent[n] = findUPar(parent[n]);
    }

    void union(int x, int y){
        int parx = findUPar(x);
        int pary = findUPar(y);

        if(parx == pary) return;

        int sizex = size[parx];
        int sizey = size[pary];

        if(sizex > sizey){
            parent[pary] = parx;
            size[parx] += sizey;
        } else{
            parent[parx] = pary;
            size[pary] += sizex;
        }
    }
}