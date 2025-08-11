class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr = new int[101];
        int[] ans = new int[2];
        int j = 0;
        for(int i : nums){
            arr[i]++;
            if(arr[i] > 1){
                ans[j++] = i;
            }
            if(j == 2) break;
        }
        return ans;
    }
}