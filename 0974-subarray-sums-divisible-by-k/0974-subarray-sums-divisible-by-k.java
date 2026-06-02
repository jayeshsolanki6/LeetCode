class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int j = 0; j<len; j++){
            sum = (sum + nums[j] % k + k)%k;
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}