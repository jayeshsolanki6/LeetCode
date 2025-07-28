class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int i : nums){
            max = max|i;
        }
        return solve(nums, nums.length - 1, max, 0);
    }
    int solve(int[] nums, int index, int max, int currOr){
        if(index == -1){
            return (currOr == max)? 1 : 0;
        }
        int take = solve(nums, index-1, max, currOr|nums[index]);
        int notake = solve(nums, index-1, max, currOr);
        return take + notake;
    }
}