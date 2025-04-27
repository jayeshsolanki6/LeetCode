class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int len = nums.length;
        for(int i = 1; i<len-1; i++){
            if(2*(nums[i-1] + nums[i+1]) == nums[i]) count++;
        }
        return count;
    }
}