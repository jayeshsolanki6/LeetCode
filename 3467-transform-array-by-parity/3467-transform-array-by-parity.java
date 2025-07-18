class Solution {
    public int[] transformArray(int[] nums) {
        int even = 0, odd = 0;
        for(int i : nums){
            if(i%2 == 0) even++;
            else odd++;
        }
        int i = 0;
        while(even != 0){
            nums[i] = 0;
            i++;
            even--;
        }
        while(odd != 0){
            nums[i] = 1;
            i++;
            odd--;
        }
        return nums;
    }
}