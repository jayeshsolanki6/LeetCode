class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int pro = 1;
        int i = 0;
        int count = 0;
        for(int j = 0; j<len; j++){
            pro *= nums[j];
            while(i <= j && pro >= k){
                pro /= nums[i++];
            }
            if(pro < k)
                count += j-i+1;
        }
        return count;
    }
}