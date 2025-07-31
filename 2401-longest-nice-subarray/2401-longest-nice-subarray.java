class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        if(len == 1) return 1;
        int xor = nums[0], sum = nums[0];
        int count = 1, max = 1;
        for(int i = 1; i<len; i++){
            if((nums[i-1] & nums[i]) == 0){
                sum += nums[i];
                xor ^= nums[i];
                if(sum == xor){
                    count++;
                } else{
                    max = Math.max(max, count);
                    count = 2;
                    sum = nums[i] + nums[i-1];
                    xor = nums[i] + nums[i-1];
                }
            } else{
                max = Math.max(max, count);
                count = 1;
                sum = nums[i];
                xor = nums[i];
            }
            max = Math.max(max, count);
        }
        return max;
    }
}