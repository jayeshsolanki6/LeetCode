class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDif = 0;
        int len = nums.length;
        for(int i = 0; i<len; i++){
            maxDif = Math.max(maxDif, Math.abs(nums[i] - nums[(i+1) % len]));
        }
        return maxDif;
    }
}