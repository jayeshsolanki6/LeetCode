class Solution {
    public int longestMountain(int[] arr) {
        int len = arr.length;
        int max = 0;

        for(int i = 1; i<len-1; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int sum = 0;
                int j = i-1;
                while(j >= 0 && arr[j] < arr[j+1]) {
                    sum++;
                    j--;
                }
                j = i+1;
                while(j < len && arr[j-1] > arr[j]) {
                    sum++;
                    j++;
                }
                max = Math.max(max, sum+1);
            }
        }
        return max;
    }
}