class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1;
        int odd = 0;
        int sum = 0;
        long res = 0;
        int mod = (int)1e9 + 7;

        for(int num : arr){
            sum += num;
            if(sum%2 == 0){
                res += odd;
                even++;
            } else{
                res += even;
                odd++;
            }
            res %= mod;
        }
        return (int)(res%mod);
    }
}