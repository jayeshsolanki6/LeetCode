class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i<len; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<len; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1, l = len-1;
                while(k < l){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[l];
                    if(sum == (long)target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while(k < l && nums[k] == nums[k+1]) k++;
                        while(k < l && nums[l] == nums[l-1]) l--;
                        k++;
                        l--;
                    } else if(sum > (long)target){
                        l--;
                    } else k++; 
                }  
            }
        }
        return list;
    }
}