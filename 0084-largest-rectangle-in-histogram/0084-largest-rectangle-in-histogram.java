class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nml = new int[len];
        int[] nmr = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<len; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nml[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
        
        stack.clear();

        for(int i = len-1; i>=0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nmr[i] = stack.isEmpty() ? len : stack.peek();
            stack.add(i);
        }

        int max = 0;

        for(int i = 0; i<len; i++){
            int area = (nmr[i] - nml[i] - 1)*heights[i];
            max = Math.max(area, max);
        }
        return max;
    }
}