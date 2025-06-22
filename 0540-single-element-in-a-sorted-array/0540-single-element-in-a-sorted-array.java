class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int low = 0, high = len-1;
        while(low<=high){
            if(low == high){
                return nums[low];
            }
            if(nums[low] != nums[low+1]){
                return nums[low];
            } else{
                low+=2;
            }
            if(nums[high] != nums[high-1]){
                return nums[high];
            } else{
                high-=2;
            }
        }
        return -1;
    }
}