class Solution {
    public int minMoves2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int pvt = nums[(len-1)/2];

        int res = 0;
        for(int i : nums) res += Math.abs(i-pvt);
        return res;
    }
}