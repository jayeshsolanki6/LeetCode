class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int winLen = 0;
        int i = 0, j = 0;
        long total = 0;

        while (j < len) {
            total += nums[j];
            if ((long)(j - i + 1) * nums[j] <= total + k) {
                winLen = Math.max(winLen, j - i + 1);
                j++;
            } else {
                total = total - nums[i] - nums[j];
                i++;
            }
        }
        return winLen;
    }
}