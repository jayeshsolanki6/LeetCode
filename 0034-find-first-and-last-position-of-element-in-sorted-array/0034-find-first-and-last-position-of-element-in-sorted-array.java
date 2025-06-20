class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1;
        int[] out = new int[]{-1, -1};

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                out[0] = mid;
                high = mid - 1;
            }
        }
        if(out[0] == -1){
            return out;
        }
        low = 0;
        high = len - 1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > target){
                high = mid - 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else{
                out[1] = mid;
                low = mid + 1;
            }
        }
        return out;
        
    }
}