class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = len-1; i>1; i--){
            for(int j = i-1; j>0; j--){
                for(int k = j-1; k>=0; k--){
                    int a = nums[i], b = nums[j], c = nums[k];
                    if(c + b > a) return a+b+c;
                }
            }
        }
        return 0;
    }
}