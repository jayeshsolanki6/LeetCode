class Solution {
    public int alternatingSum(int[] nums) {
        int even = 0, odd = 0, flag = 0;
        for(int i : nums){
            if(flag == 0){
                even += i;
            } else{
                odd += i;
            }
            flag = 1 - flag;
        }
        return even - odd;
    }
}