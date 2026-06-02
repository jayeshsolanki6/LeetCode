class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        int[] prefix = new int[k];
        prefix[0] = 1;
        int sum = 0;
        int count = 0;
        for(int j = 0; j<len; j++){
            sum = (sum + nums[j] % k + k)%k;
            count += prefix[sum];
            prefix[sum]++;
        }
        return count;
    }
}