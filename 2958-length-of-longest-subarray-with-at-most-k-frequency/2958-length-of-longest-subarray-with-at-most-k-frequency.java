class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int l = 0;
        for(int r = 0; r<len; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            while(map.get(nums[r]) > k){
                int lf = map.get(nums[l]);
                if(lf == 1) map.remove(nums[l]);
                else map.put(nums[l], lf-1);
                l++;
            }

            max = Math.max(max, r-l+1);
        }

        return max;
    }
}