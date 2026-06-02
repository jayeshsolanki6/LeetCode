class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int diff = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for(int i = 0; i<len; i++){
            if(nums[i] == 1) diff++;
            else diff--;

            if(diff == 0) max = i+1;
            if(map.containsKey(diff)){
                max = Math.max(max, i-map.get(diff));
            } else{
                map.put(diff, i);
            }
        }

        return max;
        
    }
}