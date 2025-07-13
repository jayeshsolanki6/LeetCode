class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 1;
        int low = 1, high = max(piles), hours = 0;
        while(low <= high){
            int mid = (low+high)/2;
            hours = 0;
            for(int i : piles){
                hours += Math.ceil((double)i/(double)mid);
            }
            if(hours > h){
                low = mid+1;
            } else if(hours <= h){
                high = mid-1;
            }
        }
        return low;
    }
    int max(int[] arr){
        int max = arr[0];
        for(int i : arr){
            max = Math.max(max, i);
        }
        return max;
    }
}