class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int one = 0, zero = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for(int i = 0; i<len; i++){
            if(nums[i] == 1) one++;
            else zero++;

            if(one == zero) max = one+zero;
            if(map.containsKey(one-zero)){
                max = Math.max(max, i-map.get(one-zero));
            } else{
                map.put(one-zero, i);
            }
        }

        return max;
        
    }
}