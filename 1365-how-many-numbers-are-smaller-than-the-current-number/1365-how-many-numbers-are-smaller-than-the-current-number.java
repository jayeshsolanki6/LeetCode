class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0; i<len; i++){
            int count = 0;
            int num = nums[i];
            for(int j : nums){
                if(j < num) count++;
            }
            res[i] = count;
        }
        return res;
    }
}