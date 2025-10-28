class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        long max = 0;
        long sum = 0;
        while(j < len){
            sum += nums[j];
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            set.add(nums[j]);
            if(j-i+1 < k) {
                j++;
                continue;
            }
            if(j-i+1 == set.size()){
                max = Math.max(max, sum);
            }
            sum-=nums[i];
            set.remove(nums[i]);
            i++;
            j++;
        }
        return max;
    }
}