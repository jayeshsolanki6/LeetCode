class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] res = new int[len*2];
        int i = 0;
        for(int j : nums){
            res[i++] = j;
        }
        for(int j : nums){
            res[i++] = j;
        }
        return res;
    }
}