class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        int i = l - 2;
        while(i>=0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        if(i < 0){
            Arrays.sort(nums);
        } else{
            int j = i;
            int max = j+1;
            while(j<l){
                if(nums[i] < nums[j] && nums[j] < nums[max]){
                    max = j;
                }
                j++;
            }
            int temp = nums[max];
            nums[max] = nums[i];
            nums[i] = temp;

            Arrays.sort(nums, i+1, l);
        }
    }
}