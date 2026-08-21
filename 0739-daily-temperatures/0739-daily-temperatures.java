class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int len = temp.length;
        int[] res = new int[len];

        for(int i = len-1; i>=0; i--){
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]){
                stack.pop();
            }
            if(stack.isEmpty()) res[i] = 0;
            else res[i] = stack.peek() - i;
            stack.push(i);
        }

        return res;
    }
}