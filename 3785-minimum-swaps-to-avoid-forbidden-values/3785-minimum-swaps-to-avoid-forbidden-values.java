class Solution {
    public int minSwaps(int[] nums, int[] forb) {
        int len = nums.length;
        Map<Integer, Integer> n = new HashMap<>();
        Map<Integer, Integer> f = new HashMap<>();
        int res = 0;
        for(int i = 0; i<len; i++){
            n.put(nums[i], n.getOrDefault(nums[i], 0)+1);
            f.put(forb[i], f.getOrDefault(forb[i], 0)+1);
        }

        for(int key : n.keySet()){
            if(f.containsKey(key) && f.get(key) > len-n.get(key)){
                return -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        int bad = 0, maxB = 0;
        for(int i = 0; i<len; i++){
            if(nums[i] == forb[i]){
                bad++;
                int c = map.getOrDefault(nums[i], 0) + 1;
                map.put(nums[i], c);
                maxB = Math.max(maxB, c);
            }
        }
        return Math.max(maxB, (bad+1)/2);
    }
}