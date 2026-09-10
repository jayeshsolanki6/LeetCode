class Solution {
    public long findMaximumNumber(long k, int x) {
        long low = 1;
        long high = (long)1e17;
        
        long res = high;
        while(low <= high){
            long mid = low + (high-low)/2;
            long accm = acc(mid, x);

            if(accm <= k){
                res = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return res;
    }

    long acc(long num, int x){
        num += 1;
        long sum = 0;
        int mul = x;
        while(true){
            long pow = 1l << mul;
            long curr = num/pow;
            curr *= pow/2;
            long mod = num%pow;
            // System.out.println(pow);
            curr += Math.max(mod-pow/2, 0);
            if(curr == 0) break;
            sum += curr;
            mul += x;
        }

        return sum;
    }
}