class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean containsOne = false;

        for(int i = 0; i<len; i++){
            if(nums[i] == 1) containsOne = true;
            if(nums[i] <= 0 || nums[i] > len){
                nums[i] = 1;
            }
        }

        if(!containsOne) return 1;

        for(int i = 0; i<len; i++){
            int num = Math.abs(nums[i]);
            nums[num-1] = -Math.abs(nums[num-1]);
        }

        for(int i = 0; i<len; i++){
            if(nums[i] > 0) return i+1;
        }

        return len+1;
    }
}