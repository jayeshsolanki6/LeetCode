class Solution {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i<len; i++){
            int min = nums[i], max = nums[i];
            for(int j = i; j<len; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max-min);
            }
        }
        return sum;
    }
}