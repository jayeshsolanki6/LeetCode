class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    int helper(int[] nums, int k){
        if(k == 0) return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int len = nums.length;
        while(j < len){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() > k){
                if(map.get(nums[i]) == 1){
                    map.remove(nums[i]);
                } else{
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
                i++;
            }
            if(map.size() <= k){
                count += (j-i+1);
            }
            j++;
        }
        return count;
    }
}