class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        int preSum = 0;
        prefix.put(0,1);
        for(int i = 0; i<len; i++){
            preSum += nums[i];
            if(prefix.containsKey(preSum-k)){
                res += prefix.get(preSum - k);
            }
            prefix.put(preSum, prefix.getOrDefault(preSum, 0) + 1);
        }
        return res;
        
    }
}