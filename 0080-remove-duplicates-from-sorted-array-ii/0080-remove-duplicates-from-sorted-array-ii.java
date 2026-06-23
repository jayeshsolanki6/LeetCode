class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int k = 2;
        for(int i = 2; i<len; i++){
            if(nums[k-2] != nums[i]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}