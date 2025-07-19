class Solution {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        for(int i : arr){
            if(i <= k) k++;
            else break;
        }
        return k;
    }
}