class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int res = 0;
        for(int i = 0; i<len; i++){
            int sum = 0;
            for(int j = i; j<len; j++){
                sum += arr[j];
                if((j-i+1)%2 == 1) res+=sum;
            }
        }
        return res;
    }
}