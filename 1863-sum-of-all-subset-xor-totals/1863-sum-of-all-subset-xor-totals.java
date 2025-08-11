class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        calculate(nums, nums.length-1, 0);
        return sum;
    }
    void calculate(int[] nums, int ind, int xor){
        if(ind < 0){
            sum += xor;
            return;
        }
        calculate(nums, ind-1, xor);
        xor ^= nums[ind];
        calculate(nums, ind-1, xor);
        return;
    }
}