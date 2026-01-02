class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        for(int i = 0; i<len-2; i++){
            if(nums[i] == nums[i+1] || nums[i] == nums[i+2]) return nums[i];
            if(nums[i+1] == nums[i+2]) return nums[i+1];

        }
        return nums[0];
    }
}