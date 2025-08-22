class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int check = len/3;
        int can = 0;
        for(int i = 0; i<len; i++){
            if(count == 0){
                can = nums[i];
            }
            if(can == nums[i]){
                count++;
            } else{
                count = 0;
                i--;
            }
            if(count == check+1){
                list.add(nums[i]);
            }
        }
        return list;
    }
}