class Solution {
    public int specialTriplets(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> pre = new HashMap<>();
        HashMap<Integer, Integer> post = new HashMap<>();
        for(int i = 1; i<len; i++){
            post.put(nums[i], post.getOrDefault(nums[i], 0) + 1);
        }
        pre.put(nums[0], 1);
        long count = 0;
        for(int i = 1; i<len; i++){
            post.put(nums[i], post.getOrDefault(nums[i], 0) - 1);
            if(pre.containsKey(nums[i]*2) && post.containsKey(nums[i]*2)){
                count += (1L * pre.get(nums[i]*2) * post.get(nums[i]*2));
            }
            pre.put(nums[i], pre.getOrDefault(nums[i], 0)+1);
        } 
        return (int)count % (int)(1e9+7);
    }
}