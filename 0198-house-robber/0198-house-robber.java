class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int rob1 = 0, rob2 = 0;
        int temp = 0;
        for(int n : nums){
            if(temp == 0){
                rob1 += n;
            } else{
                rob2 += n;
            }
            temp = 1 - temp;
        }
        return Math.max(rob1, rob2);
    }
}