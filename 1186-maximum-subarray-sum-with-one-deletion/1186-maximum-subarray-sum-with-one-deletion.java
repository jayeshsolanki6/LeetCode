class Solution {
    public int maximumSum(int[] arr) {
        int len = arr.length;

        int afterDel = 0;
        int withoutDel = arr[0];
        int max = arr[0];

        for(int i = 1; i<len; i++){
            afterDel = Math.max(afterDel + arr[i], withoutDel);
            withoutDel = Math.max(withoutDel + arr[i], arr[i]);

            max = Math.max(max, Math.max(afterDel, withoutDel));
        }

        return max;
    }
}