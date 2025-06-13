class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] arr = new int[2];
        Map<Integer, Integer> save = new HashMap<>();
        for(int i = 0; i<len; i++){
            if(save.containsKey(target - nums[i])){
                arr[0] = save.get(target - nums[i]);
                arr[1] = i;
                return arr;
            }
            save.put(nums[i], i);
        }
        return null;
        

    }
}