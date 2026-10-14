class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = (int)1e9 + 7;
        int[] bits = new int[32];
        for(int num : nums){
            int i = 0;
            while(num > 0){
                int bit = num&1;
                num = num >> 1;
                bits[i++] += bit;
            }
        }

        long res = 0;
        while(k-- > 0){
            long num = 0;
            for(int i = 0; i<32; i++){
                if(bits[i] > 0){
                    num |= (1 << i);
                    bits[i]--;
                }
            }
            res += num*num;
            res %= mod;
        }
        return (int)res;
    }
}
