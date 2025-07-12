class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] ans = new int[len];
        for(int i = len-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        for(int i = len-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return ans;
    }
}