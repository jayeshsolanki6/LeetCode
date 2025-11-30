class Solution {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        int res = len;
        long sum = 0;
        for(int i : nums) sum += i;
        sum %= p;
        if(p == 0) return 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i<len; i++){
            pre = (pre + nums[i]) % p;
            map.put(pre, i);
            int target = (int)(pre-sum+p)%p;
            if(map.containsKey(target)){
                res = Math.min(i - map.get(target), res);
            }
        }
        if(res == len) return -1;
        return res;
    }
}