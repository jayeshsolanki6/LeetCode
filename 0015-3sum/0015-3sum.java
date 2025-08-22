class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
       
        for(int i = 0; i<len; i++){
            if(i != 0){
                if(nums[i] == nums[i-1]){
                    continue;
                }
            }
            int j = i+1, k = len-1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
                    list.add(l);
                    while(j<k && nums[j] == nums[j+1]) j++;
                    while(j<k && nums[k-1] == nums[k]) k--;
                    j++;
                    k--;
                }
                else if(sum > 0){
                    k--;
                    continue;
                } else{
                    j++;
                }
            }

        } 
        return list;
    }
}