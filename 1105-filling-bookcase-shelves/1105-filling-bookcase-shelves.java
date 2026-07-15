class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len+1]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i<=len; i++){
            int w = 0;
            int h = 0;

            for(int j = i-1; j>=0; j--){
                if(w + books[j][0] > shelfWidth) break;
                w += books[j][0];
                h = Math.max(h, books[j][1]);

                dp[i] = Math.min(dp[i], dp[j]+h);
            }
        }

        return dp[len];
    }
    
}