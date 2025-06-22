class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int min = nums[0];
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[high]){
                return nums[low];
            } else if(nums[low]<=nums[mid] && nums[mid]>=nums[high]){
                min = nums[high];
                low = mid+1;
            } else{
                min = nums[mid];
                high = mid;
            }
        }
        // while(low<=high){
        //     int mid = (low+high)/2;
        //     if(nums[low]<=nums[high]){
        //         return Math.min(min,nums[low]);
        //     } else if(nums[low]<=nums[mid]){
        //         min = Math.min(min,nums[low]);
        //         low = mid+1;
        //     } else{
        //         min = Math.min(min,nums[mid]);
        //         high = mid-1;
        //     }
        // }
        return min;
    }
}