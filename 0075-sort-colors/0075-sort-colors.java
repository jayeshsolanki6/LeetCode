class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int[] count = new int[3];
        for(int i = 0; i < len; i++){
            count[nums[i]]++;
        }
        int j = 0;
        for(int i = 0; i<3; i++){
            int c = count[i];
            while(c > 0){
                nums[j++] = i;
                c--;
            }
        }
    }
}