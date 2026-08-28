class Solution {
    public int maximumSum(int[] arr) {
        int len = arr.length;

        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int i : arr){
            curr = Math.max(curr + i, i);
            max = Math.max(max, curr);
        }

        int[] pre = new int[len];
        int[] suff = new int[len];
        pre[0] = arr[0];
        suff[len-1] = arr[len-1];

        for(int i = 1; i<len; i++){
            pre[i] = Math.max(pre[i-1] + arr[i], arr[i]);
        }
        for(int i = len-2; i>=0; i--){
            suff[i] = Math.max(suff[i+1] + arr[i], arr[i]);
        }

        for(int i = 1; i<len-1; i++){
            max = Math.max(max, pre[i-1] + suff[i+1]);
        }
        return max;
    }
}