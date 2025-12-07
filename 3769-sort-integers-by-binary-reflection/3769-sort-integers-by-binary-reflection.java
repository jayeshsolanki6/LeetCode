class Solution {
    public int[] sortByReflection(int[] nums) {
        int len = nums.length;
        int[][] arr = new int[len][2];
        for(int i = 0; i<len; i++){
            arr[i][0] = nums[i];
            arr[i][1] = reflection(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> ((a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]));
        for(int i = 0; i<len; i++){
            nums[i] = arr[i][0];
        }
        return nums;
    }
    int reflection(int num){
        String s = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
        return Integer.parseInt(s, 2);
    }
}
