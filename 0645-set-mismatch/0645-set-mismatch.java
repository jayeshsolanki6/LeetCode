class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        int uniqueSum = 0;
        int sum = len*(len+1)/2;
        int duplicate = -1;
        for(int i : nums){
            if(set.contains(i)){
                duplicate = i;
            } else{
                uniqueSum += i;
                set.add(i);
            }
        }
        return new int[]{duplicate, sum-uniqueSum};
    }
}