class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int total = 0;
        for(int i : neededTime) total += i;
        int time = 0, max = neededTime[0];
        int len = arr.length;
        for(int i = 1; i<len; i++){
            if(arr[i] == arr[i-1]){
                max = Math.max(max, neededTime[i]);
            } else{
                time += max;
                max = neededTime[i];
            }
        }
        time += max;
        return total - time;
    }
}