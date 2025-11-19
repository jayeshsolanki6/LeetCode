class Solution {
    public int findFinalValue(int[] nums, int original) {
        int max = original;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        while(set.contains(max)){
            max*=2;
        }
        return max;
    }
}