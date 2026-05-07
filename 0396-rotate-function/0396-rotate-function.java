class Solution {
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int sum = 0, F = 0;

        for(int i = 0; i<len; i++){
            sum += nums[i];
            F += i * nums[i];
        }

        int max = F;

        for(int i = 1; i<len; i++){
            F += sum - len*nums[len-i];
            max = Math.max(max, F);
        }

        return max;
    }
}