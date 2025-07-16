class Solution {
    public int maximumLength(int[] nums) {
        int len = nums.length;
        int count = 0, even = 0, odd = 0, temp = nums[0]%2;
        for(int i : nums){
            if(i%2 == temp){
                temp = 1-temp;
                count++;
            }
            if(i%2 == 0) even++;
            if(i%2 == 1) odd++;
        }
        return Math.max(count, Math.max(even, odd));
    }
}