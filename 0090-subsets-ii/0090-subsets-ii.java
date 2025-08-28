class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        helper(nums, 0, len, new ArrayList<>());
        return list;
    }
    void helper(int[] nums, int ind, int len, ArrayList<Integer> li){
        if(ind == len){
            list.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[ind]);
        helper(nums, ind+1, len, li);
        li.remove(li.size() - 1);

        while(ind < len-1 && nums[ind] == nums[ind+1]) ind++;
        helper(nums, ind+1, len, li);
    }
}