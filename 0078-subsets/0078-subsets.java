class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        int len = nums.length;
        int bit = 1 << len;
        for(int i = 0; i<bit; i++){
            List<Integer> newLi = new ArrayList<>();
            for(int j = 0; j<len; j++){
                if((i & (1 << j)) > 0){
                    newLi.add(nums[j]);
                }
            }
            list.add(newLi);
        }

        return list;
    }

}