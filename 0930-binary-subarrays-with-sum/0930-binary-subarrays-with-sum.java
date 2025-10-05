class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length;
        int win = 0;
        int count = 0;
        while(win < len){
            int i = 0, j = win;
            int sum = 0;
            for(int k = i; k<=j; k++){
                sum += nums[k];
            } 
            if(sum == goal) count++;
            i++; j++;
            while(j < len){
                sum = sum - nums[i-1] + nums[j];
                if(sum == goal) count++;
                i++;
                j++;
            }
            win++;
        }
        return count;
    }
}