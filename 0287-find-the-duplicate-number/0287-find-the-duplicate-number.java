class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for(int i = 0; i<len; i++){
            int num = Math.abs(nums[i]);
            if(nums[num-1] < 0) return num;
            nums[num-1] = -nums[num-1];
        }
        return -1;
    }
}