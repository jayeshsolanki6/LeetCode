class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[len-1] != nums[len-2]) return nums[len-1];
        int low = 1, high = len-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid] != nums[mid+1]){
                if(mid%2 == 0){
                    high = mid-2;
                } else{
                    low = mid+1;
                }
            } else{
                if(mid%2 == 0){
                    low = mid + 2;
                } else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
//         int len = nums.length;
//         int low = 0, high = len-1;
//         while(low<=high){
//             if(low == high){
//                 return nums[low];
//             }
//             if(nums[low] != nums[low+1]){
//                 return nums[low];
//             } else{
//                 low+=2;
//             }
//             if(nums[high] != nums[high-1]){
//                 return nums[high];
//             } else{
//                 high-=2;
//             }
//         }
//         return -1;