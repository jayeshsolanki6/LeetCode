class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int len = nums.length;
        int[] res = new int[len];
        int i = 0, count = 0;
        for(int j = 0; j<len; j++){
            if(nums[j] < pivot){
                res[i++] = nums[j];
            } else if(nums[j] == pivot){
                count++;
            }
        }
        while(count > 0){
            res[i++] = pivot;
            count--;
        }
        for(int j = 0; j<len; j++){
            if(nums[j] > pivot){
                res[i++] = nums[j];
            }
        }
        return res;
    }
}