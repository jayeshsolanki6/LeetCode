class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n) return -1;

        int l = 0, r = 0;
        for(int i : bloomDay){
            l = Math.min(l, i);
            r = Math.max(r, i);
        }
        int min = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            int bouquet = helper(bloomDay, k, mid);
            if(bouquet < m){
                l = mid+1;
            } else{
                r = mid-1;
                min = mid;
            }
        }
        return min;

    }
    int helper(int[] arr, int k, int day){
        int count = 0;
        int j = 0;
        for(int i : arr){
            if(i > day){
                count += j/k;
                j = 0;
            } else{
                j++;
            }
        }
        count += j/k;
        return count;
    }
}