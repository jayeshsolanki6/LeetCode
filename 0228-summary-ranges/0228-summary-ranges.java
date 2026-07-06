class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;

        if(len == 0) return list;

        int i = 0, j = 1;
        while(j < len){
            if(nums[j-1]+1 != nums[j]){
                String s = "";
                if(i == j-1){
                    s += nums[i];
                } else{
                    s += nums[i];
                    s += "->";
                    s += nums[j-1];
                }
                list.add(s);
                i = j;
            } 
            j++;
        }
        String s = "";
        if(i == j-1){
            s += nums[i];
        } else{
            s += nums[i];
            s += "->";
            s += nums[j-1];
        }
        list.add(s);
        return list;
    }
}