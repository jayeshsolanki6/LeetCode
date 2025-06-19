class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int res = len;
        int f = 0, l = len -1;
        while(f<=l){
            int mid = (f+l)/2;
            if(target < nums[mid]){
                res = mid;
                l = mid - 1;
            } else if(nums[mid] == target){
                return mid;
            } else{
                f = mid+1;
            }
        }
        return res;
    }
}