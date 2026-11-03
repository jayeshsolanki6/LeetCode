class Solution {
    public int minMoves(int[] nums) {
        int max = 0, sum = 0;
        for(int i : nums){
            if(max < i) max = i;
            sum += i;
        }
        return nums.length*max-sum;
    }
}