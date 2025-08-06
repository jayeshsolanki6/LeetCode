class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        while(low <= high){
            int mid = (low + high)/2;
            int sqr = mid * mid;
            if(sqr == x) return mid;
            if(sqr > x){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low-1;
    }
}