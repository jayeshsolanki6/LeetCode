class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0], nums[1]);

        // from 0 to n-2
        int pre2 = nums[0];
        int pre1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i<len-1; i++){
            int curr = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = curr;
        }

        int res1 = pre1;

        // from 1 to n-1
        pre2 = nums[1];
        pre1 = Math.max(nums[2], nums[1]);
        for(int i = 3; i<len; i++){
            int curr = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = curr;
        }

        return Math.max(res1, pre1);
    }
}