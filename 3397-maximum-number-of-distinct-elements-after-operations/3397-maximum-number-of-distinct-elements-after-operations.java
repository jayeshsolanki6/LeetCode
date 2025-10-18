class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0, prev = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr = Math.max(num - k, prev + 1);
            if (curr <= num + k) {
                prev = curr;
                cnt++;
            }
        }
        return cnt;
    }
}