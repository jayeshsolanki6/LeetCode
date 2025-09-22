class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] hash = new int[101];
        int max = 0;
        for(int i : nums){
            hash[i]++;
            max = Math.max(max, hash[i]);
        }
        int count = 0;
        for(int i : hash){
            if(i == max) count += max;
        }
        return count;
    }
}