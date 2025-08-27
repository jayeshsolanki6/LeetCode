class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        generate(nums, 0, len, new ArrayList<>());
        return list;
    }
    void generate(int[] nums, int ind, int len, List<Integer> li){
        if(ind == len){
            list.add(li);
            return;
        }
        List<Integer> newLi = new ArrayList<>(li);
        newLi.add(nums[ind]);
        generate(nums, ind+1, len, li);
        generate(nums, ind+1, len, newLi);
    }
}