class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] location = new int[1001];
        for(int[] trip : trips){
            location[trip[1]] += trip[0];
            location[trip[2]] -= trip[0];
        }
        int passengers = 0;
        for(int val : location){
            passengers += val;
            if(passengers > capacity) return false;
        }
        return true;
    }
}