class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len+1]; 
        Arrays.fill(dp, -1);
        return find(len-1, shelfWidth, books, dp);
    }

    int find(int i, int width, int[][] books, int[] dp){
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];

        int minH = Integer.MAX_VALUE;
        int h = 0;
        int w = 0;
        for(int j = i; j >= 0; j--){
            if(w + books[j][0] > width) break;
            w += books[j][0];
            h = Math.max(h, books[j][1]);
            minH = Math.min(minH, h + find(j-1, width, books, dp));
        }

        return dp[i] = minH;
    }
}