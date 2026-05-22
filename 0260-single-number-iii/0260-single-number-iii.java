class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int i : nums) xor = xor ^ i;

        int rmsb = (xor & (xor-1)) ^ xor; //right most set bit

        int a = 0, b = 0;

        for(int i : nums){
            if((rmsb & i) == 0){
                a = a ^ i;
            } else{
                b = b ^ i;
            }
        }

        return new int[]{a, b};
    }
}