class Solution {
    public int countValidSelections(int[] nums) {
        int res = 0;
        int sum = 0;
        for(int i : nums) sum+=i;
        int preSum = 0;
        for(int i : nums){
            if(i == 0){
                int postSum = sum - preSum;
                if(postSum == preSum) res += 2;
                else if(Math.abs(preSum - postSum) == 1) res += 1;
            }
            preSum += i;
        }
        return res;
    }
}