class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] can;
    int len;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        len = candidates.length;
        can = candidates;
        helper(0, new ArrayList<>(), target);
        return list;
    }
    void helper(int ind, ArrayList<Integer> li, int target){
        if(target == 0){
            list.add(new ArrayList<>(li));
            return;
        }
        if(ind == len) return;
        if(can[ind] <= target){
            li.add(can[ind]);
            helper(ind, li, target-can[ind]);
            li.remove(li.size() - 1);
        }
        helper(ind+1, li, target);
    }
}