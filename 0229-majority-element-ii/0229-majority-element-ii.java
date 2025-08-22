class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        int check = len/3;
        for(int i = 0; i<len; ){
            int j = i+1;
            while(j < len && nums[j] == nums[i])j++;
            if(j-i > check){
                list.add(nums[i]);
            }
            i = j;
        }
        return list;
    }
}