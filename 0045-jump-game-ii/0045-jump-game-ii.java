class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int jump = 0;
        int l = 0, r = 0;
        while(r < len-1){
            for(int i = l; i<=r; i++){
                l = Math.max(l, nums[i] + i);
            }
            jump++;
            int temp = r;
            r = l;
            l = temp+1;
        }
        return jump;
        
    }

}