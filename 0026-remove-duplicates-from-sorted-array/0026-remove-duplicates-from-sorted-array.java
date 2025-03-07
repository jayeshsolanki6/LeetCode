class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[k] != nums[i]){
                nums[++k] = nums[i];
            } else{continue;}
        }
        return k+1;
    }
}