class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int len = nums.length;
        int f = 0, l = len -1;
        while(f<=l){
            int mid = (f+l)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid]>target){
                l = mid - 1;
            } else{
                f = mid + 1;
            }
        }
        return res;
    }
}