class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        for(int x = 0; x<k; x++){
            for(int y = 0; y<k; y++){
                if(x == y) continue;
                int op = 0;
                for(int i = 0; i<n; i++){
                    int r = nums[i]%k;
                    if(i%2 == 0){
                        int diff = Math.abs(r-x);
                        op += Math.min(diff, k-diff);
                    } else{
                        int diff = Math.abs(r-y);
                        op += Math.min(diff, k-diff);
                    }
                }
                res = Math.min(res, op);
            }
        }

        return res;
    }
}