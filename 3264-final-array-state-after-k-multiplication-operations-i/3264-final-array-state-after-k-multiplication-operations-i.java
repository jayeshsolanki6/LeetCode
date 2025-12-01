class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int len = nums.length;
        for(int i = 0; i<k; i++){
            int ind = 0;
            for(int j = 0; j<len; j++){
                ind = (nums[ind] <= nums[j]) ? ind : j;
            }
            nums[ind] = nums[ind]*multiplier;
        }
        return nums;
    }
}