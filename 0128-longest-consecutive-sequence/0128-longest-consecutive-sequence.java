class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len<=1) return len;
        int max = 0, count = 0;
        for(int i = 0; i<len-1; i++){
            if(nums[i] + 1 == nums[i+1]){
                count++;
                max = Math.max(max,count);
            } else if(nums[i] == nums[i+1]){
                continue;
            } else{
                count = 0;
            }
        }
        return max + 1;
    }
}