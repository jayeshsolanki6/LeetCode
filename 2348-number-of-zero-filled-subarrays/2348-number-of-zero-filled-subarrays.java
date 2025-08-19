class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // int len = nums.length;
        int res = 0;
        int count = 0;
        for(int i : nums){
            if(i != 0 && count != 0){
                res += count*(count+1)/2;
                count = 0;
            }else if(i == 0){
                count++;
            }
        }
        res += count*(count+1)/2;
        return res;
    }
}