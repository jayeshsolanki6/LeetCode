class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 0;
        for(int i = 1; i<n; i++){
            if(nums[k] != nums[i]){
                nums[++k] = nums[i];
            } else{continue;}
        }
        return k+1;
    }
}