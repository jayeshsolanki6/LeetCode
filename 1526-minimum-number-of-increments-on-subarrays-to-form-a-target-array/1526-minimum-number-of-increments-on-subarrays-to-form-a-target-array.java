class Solution {
    public int minNumberOperations(int[] target) {
        int len = target.length;
        int ans = target[0];
        for(int i = 1; i<len; i++){
            ans += Math.max(target[i] - target[i-1], 0);
        }
        return ans;
    }
}