class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, dec = 1, max = 0;
        if(nums.length == 0){
            return 0;
        } if(nums.length == 1){
            return 1;
        }
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]<nums[i]){
                inc++;
            } else{inc = 1;}
                
            if(nums[i-1]>nums[i]){
                dec++;
            } else{dec = 1;}

            max = Math.max(max,Math.max(inc,dec));
        }
    return max;
    }
}