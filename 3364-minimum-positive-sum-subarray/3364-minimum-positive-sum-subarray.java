class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int len = nums.size();
        int res = Integer.MAX_VALUE;

        for(int k = l; k<=r; k++){
            int j = 0;
            int sum = 0;
            for(int i = 0; i<len; i++){
                sum += nums.get(i);
                if(i-j+1 > k){
                    sum -= nums.get(j++);
                }
                if(i-j+1 == k && sum > 0){
                    res = Math.min(res, sum);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}