class Solution {
    class Pair{
        int row, col, effort;
        Pair(int r, int c, int e){
            row = r;
            col = c;
            effort = e;
        }
    }
    public int minimumEffortPath(int[][] h) {
        int row = h.length;
        int col = h[0].length;

        int[][] effort = new int[row][col];
        for(int[] eff : effort){
            Arrays.fill(eff, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Pair(0, 0, 0));

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int i = p.row, j = p.col;
            int e = p.effort;
            int wt = h[i][j];

            for(int[] d : dir){
                int ni = i + d[0];
                int nj = j + d[1];
                if(ni < 0 || ni >= row || nj < 0 || nj >= col) continue;
                int neff = Math.max(Math.abs(h[ni][nj] - wt), e);
                if(effort[ni][nj] > neff){
                    effort[ni][nj] = neff;
                    pq.add(new Pair(ni, nj, neff));
                }
            }
        }
        return effort[row-1][col-1];
    }
}