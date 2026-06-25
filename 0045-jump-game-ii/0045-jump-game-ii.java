class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int jump = 0;
        int l = 0, r = 0;

        while(r < len-1){
            int maxReach = l;
            for(int i = l; i<=r; i++){
                maxReach = Math.max(maxReach, i+nums[i]);
            }
            l = r+1;
            r = maxReach;
            jump++;
        }

        return jump;
    }
}