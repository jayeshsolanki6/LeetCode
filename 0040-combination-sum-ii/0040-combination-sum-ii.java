class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Arrays.sort(candidates);  
        helper(candidates, 0, len, target, new ArrayList<>());
        return list;
    }
    void helper(int[] arr, int ind, int len, int target, ArrayList<Integer> li){
        if(target == 0){
            list.add(new ArrayList<>(li));
            return;
        }
        if(ind == len || target < 0) return;
        li.add(arr[ind]);
        helper(arr, ind+1, len, target-arr[ind], li);
        li.remove(li.size() - 1);
        while(ind < len-1 && arr[ind] == arr[ind+1]) ind++;
        helper(arr, ind+1, len, target, li);
    }
}
