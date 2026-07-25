class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;
        if(len <= 2) return len;
        if(len == 3) return 4;
        int bitLen = 32 - Integer.numberOfLeadingZeros(len);
        return (int) Math.pow(2, bitLen);

    }
}