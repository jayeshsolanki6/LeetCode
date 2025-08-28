class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(1, 0, k, n, new ArrayList<>());
        return list;
    }
    void helper(int num, int sum, int k, int n, ArrayList<Integer> li){
        if(sum == n && k == 0){
            list.add(new ArrayList(li));
            return;
        }
        if(k == 0 || num == 10) return;
        li.add(num);
        helper(num+1, sum+num, k-1, n, li);
        li.remove(li.size() - 1);
        helper(num+1, sum, k, n, li);
    }
}