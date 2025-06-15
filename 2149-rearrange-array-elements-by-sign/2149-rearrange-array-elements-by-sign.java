class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = 0, n = 1;
        int len = nums.length;
        int[] res = new int[len];
        for(int i : nums){
            if(i>0){
                res[p] = i;
                p+=2;
            } else{
                res[n] = i;
                n+=2;
            }
        }
        return res;
    }
    // public static void swap(int[] nums, int i, int j){
    //     int tamp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = tamp;
    // }
}