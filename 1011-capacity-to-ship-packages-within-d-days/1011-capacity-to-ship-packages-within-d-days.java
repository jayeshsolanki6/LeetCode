class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int w : weights){
            high += w;
            low = Math.max(low, w);
        }
        int minWeight = low;
        while(low <= high){
            int mid = low + (high-low)/2;
            int d = daysTaken(weights, mid); 
            if(d <= days){
                minWeight = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return minWeight;
    }
    int daysTaken(int[] arr, int weight){
        int days = 1, temp = 0;
        for(int i : arr){
            if(temp+i > weight){
                days++;
                temp = i;
            } else{
                temp += i;
            }
        }
        return days;
    }
}