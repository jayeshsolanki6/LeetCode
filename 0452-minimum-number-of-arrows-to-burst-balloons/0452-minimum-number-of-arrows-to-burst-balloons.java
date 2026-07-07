class Solution {
    public int findMinArrowShots(int[][] arr) {
        int len = arr.length;
        Arrays.sort(arr, (a, b) -> (a[0] <= b[0]) ? -1 : 1);
        int end = arr[0][1];
        int res = 1;
        for(int i = 1; i<len; i++){
            if(arr[i][0] <= end){
                end = Math.min(end, arr[i][1]);
            } else{
                res++;
                end = arr[i][1];
            }
        }
        return res;
    }
}