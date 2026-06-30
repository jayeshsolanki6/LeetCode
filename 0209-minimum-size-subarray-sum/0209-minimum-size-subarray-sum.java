class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res = len+1;
        int i = 0;
        int sum = 0;
        for(int j = 0; j<len; j++){
            sum += nums[j];
            while(sum >= target){
                res = Math.min(res, j-i+1);
                sum -= nums[i];
                i++;
            }
        }

        if(res == len+1) return 0;
        return res;
    }
}