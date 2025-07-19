class Solution {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int low = 0, high = len-1;
        while(low<=high){
            int mid = (low + high)/2;
            int missing = arr[mid] - (mid + 1); 
            if(missing < k){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return low + k;
        // for(int i : arr){
        //     if(i <= k) k++;
        //     else break;
        // }
        // return k;
        // int count = 0, current = 1, i = 0;
        // while(count < k){
        //     if(i < len && arr[i] == current){
        //         i++;
        //     } else{
        //         count++;
        //     }
        //     if(count == k) return current;
        //     current++;
        // }
        // return current;
    }
}