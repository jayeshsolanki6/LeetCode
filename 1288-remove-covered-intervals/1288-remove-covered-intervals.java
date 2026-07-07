class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        int len = arr.length;
        Arrays.sort(arr, (a, b) ->(a[0] == b[0]) ? b[1]-a[1] : a[0]-b[0]);
        int end = arr[0][1]-1;
        int res = 1;
        for(int i = 1; i<len; i++){
            if(arr[i][1]-1 > end){
                res++;
                end = arr[i][1]-1;
            }
        }

        return res;
    }
}