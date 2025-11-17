class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for(int i : nums){
            if(i == 0) count++;
            else if(count < k) return false;
            else count = 0;
        }
        return true;
    }
}