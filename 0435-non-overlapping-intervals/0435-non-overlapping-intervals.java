class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int peek = Integer.MIN_VALUE;

        int res = 0;

        for(int[] interval : intervals){
            if(peek > interval[0]){
                res++;
                peek = Math.min(peek, interval[1]);
            } else{
                peek = interval[1];
            }
        }
        
        return res;
    }
}