class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int j = 0, i = 0;
        while(i<n){
            ans[j++] = nums[i];
            ans[j++] = nums[n+i];
            i++;
        }
        return ans;
    }
}