class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len+1]; 
        Arrays.fill(dp, -1);
        return find(0, shelfWidth, books, len, dp);
    }

    int find(int i, int width, int[][] books, int len, int[] dp){
        if(i == len) return 0;

        if(dp[i] != -1) return dp[i];

        int minH = Integer.MAX_VALUE;
        int h = 0;
        int w = 0;
        int temp = i;
        while(i < len && (w + books[i][0] <= width)){
            w += books[i][0];
            h = Math.max(h, books[i][1]);
            i++;
            minH = Math.min(minH, h + find(i, width, books, len, dp));
        }

        return dp[temp] = minH;
    }
}