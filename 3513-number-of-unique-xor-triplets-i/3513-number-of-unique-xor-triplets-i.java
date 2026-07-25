class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;
        if(len <= 2) return len;
        int bitLen = 32 - Integer.numberOfLeadingZeros(len);
        return (int) Math.pow(2, bitLen);

    }
}