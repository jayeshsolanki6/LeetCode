class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 0;
        digits[len-1]++;
        for(int i = len-1; i>=0; i--){
            digits[i] += carry;
            carry = 0;
            if(digits[i] < 10) break;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if(carry == 0) return digits;
        int[] ans = new int[len+1];
        ans[0] = carry;
        for(int i = 0; i<len; i++){
            ans[i+1] = digits[i];
        }
        return ans;
    }
}