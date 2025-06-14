class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int low = prices[0];
        for(int i:prices){
            maxPro = Math.max(maxPro, i - low);
            if(i<low){
                low = i;
            }
        }
        return maxPro;
    }
}