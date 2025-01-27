class Solution {
    public int[] applyOperations(int[] nums) {
        int k = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[k] == nums[i]){
                nums[k] = nums[k] * 2;
                nums[i] = 0;
            } k++;
        } k = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }
        for(;k<nums.length;k++){
            nums[k] = 0;
        }
        return nums;
    }
}