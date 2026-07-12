class Solution {
    public int minimumCost(int[] nums, int k) {
        int mod = 1_000_000_007;
        long sum = 0;
        for(int i : nums) sum += i;
        long x = ((sum+k-1)/k)-1;
        x %= mod;
        return (int)((x*(x+1)/2)%mod);
    }
}