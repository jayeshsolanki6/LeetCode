class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int tc = 0;
        int less = 0;
        for(int i : nums){
            if(target == i) tc++;
            if(i < target) less++;
        }
        List<Integer> list = new ArrayList<>();
        while(tc-->0){
            list.add(less++);
        }
        return list;
    }
}