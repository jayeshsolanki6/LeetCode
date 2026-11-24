class Solution {
    public int maxLength(int[] nums) {
        int len = nums.length;
        
        int max = 1;
        for(int i = 0; i<len; i++){
            int prod = nums[i];
            int l = nums[i];
            int g = nums[i];
            for(int j = i+1; j<len; j++){
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = lcm(l, nums[j], gcd(l, nums[j]));
                if(prod == g * l) max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
    int gcd(int a, int b){
        if(a == 0 || b == 0) return a + b;
        return gcd(b, a%b);
    }
    int lcm(int a, int b, int gcd){
        return a*b/gcd;
    }
}