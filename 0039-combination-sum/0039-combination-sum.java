class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] can;
    int len, target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        len = candidates.length;
        can = candidates;
        this.target = target;
        helper(0, new ArrayList<>(), 0);
        return list;
    }
    void helper(int ind, ArrayList<Integer> li, int sum){
        if(sum == target){
            list.add(li);
            return;
        }
        if(sum > target || ind == len) return;
        helper(ind+1, new ArrayList<>(li), sum);
        li.add(can[ind]);
        helper(ind, li, sum + can[ind]);
    }
}