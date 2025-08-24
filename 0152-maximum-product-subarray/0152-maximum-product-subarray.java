class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<len; i++){
            int pro = 1;
            for(int j = i; j<len; j++){
                pro *= nums[j];
                max = Math.max(max, pro);
            }
        }
        return max;
    }
}