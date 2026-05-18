class Solution {
    int n;
    int[][] grid;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        Map<Integer, Integer> islandSize = new HashMap<>();
        int id = 2; // start from 2 since 0 and 1 already used in grid

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, id);
                    islandSize.put(id, size);
                    id++;
                }
            }
        }

        // handle all-1s grid
        int max = (grid[0][0] != 0) ? islandSize.get(grid[0][0]) : 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int land = 1;
                    Set<Integer> seen = new HashSet<>();
                    for (int[] d : dir) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || y < 0 || x >= n || y >= n) continue;
                        int neighborId = grid[x][y];
                        if (neighborId == 0 || seen.contains(neighborId)) continue;
                        seen.add(neighborId);
                        land += islandSize.get(neighborId);
                    }
                    max = Math.max(max, land);
                }
            }
        }
        return max;

    }

    int dfs(int i, int j, int id) {
        if (i < 0 || j < 0 || i >= n || j >= n) return 0;
        if (grid[i][j] != 1) return 0;
        grid[i][j] = id; // mark with island id (avoids vis[][] array)
        int size = 1;
        for (int[] d : dir) {
            size += dfs(i + d[0], j + d[1], id);
        }
        return size;
    }
}