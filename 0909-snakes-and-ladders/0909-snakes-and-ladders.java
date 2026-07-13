class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int last = n*n-1;
        boolean[] vis = new boolean[n*n];
        vis[0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()){
            int[] temp = q.remove();
            int idx = temp[0];
            if(idx == last) return temp[1];
            
            for(int i = 1; i<=6; i++){
                if(i+idx > last || vis[i+idx]) continue;
                int newIdx = idx+i;
                vis[newIdx] = true;
                int[] index = getIndex(newIdx, n);
                int r = index[0], c =index[1];
                if(board[r][c] != -1){
                    newIdx = board[r][c]-1;
                }
                q.add(new int[]{newIdx, temp[1]+1});
            }
        }
        return -1;


    }
    int[] getIndex(int num, int n){
        int row = n-num/n-1;
        int r = num/n;
        int col = (r%2 == 0) ? num%n : n-num%n-1;
        return new int[]{row, col};
    }
}
