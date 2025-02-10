class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i: nums){
            int count = (int)(Math.log10(i)) + 1 ;
            if(count%2==0){
                ans++;
            }
        }
        return ans;
    }
}