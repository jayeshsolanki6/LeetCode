class Solution {
    public List<Integer> findValidElements(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = nums.length;

        TreeSet<Integer> set = new TreeSet<>();
        int maxL = Integer.MIN_VALUE;;
        for(int i = 0; i<len; i++){
            if(maxL < nums[i]){
                set.add(i);
                maxL = nums[i];
            }
        }
        int maxR = Integer.MIN_VALUE;;
        for(int i = len-1; i>=0; i--){
            if(nums[i] > maxR){
                set.add(i);
                maxR = nums[i];
            }
        }

        for(int i : set){
            res.add(nums[i]);
        }
        return res;
    }
}