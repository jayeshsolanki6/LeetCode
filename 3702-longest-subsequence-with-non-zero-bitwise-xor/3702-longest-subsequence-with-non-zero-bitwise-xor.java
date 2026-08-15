class Solution {
    public int longestSubsequence(int[] nums) {
        int len = nums.length;
        int xor = 0;
        int nonzero = len;
        for(int i : nums){
            xor ^= i;
            if(i == 0) nonzero--;
        }
        if(nonzero == 0) return 0;
        if(xor == 0) return len-1;
        return len;
    }
}