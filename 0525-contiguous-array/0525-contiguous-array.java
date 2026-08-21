class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int res = 0;
        int preSum = (nums[0] == 1) ? 1 : -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(preSum, 0);
        
        for(int i = 1; i<len; i++){
            preSum += ((nums[i] == 1) ? 1 : -1);
            if(preSum == 0) res = i+1;
            else if(map.containsKey(preSum)){
                res = Math.max(res, i - map.get(preSum));
            } else map.put(preSum, i);
        }
        return res;
    }
}