class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i<len; i++){
            nums[i] = nums[i]*nums[i];
        }
        int l = 0, r = len-1;
        int i = len-1;
        while(l <= r){
            if(nums[l] > nums[r]){
                res[i--] = nums[l++];
            } else{
                res[i--] = nums[r--];
            }
        }
        return res;
    }
}