class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<len; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) left[i] = -1;
            else left[i] = st.peek();
            st.add(i);
        }
        st.clear();
        for(int i = len-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            if(st.isEmpty()) right[i] = len;
            else right[i] = st.peek();
            st.add(i);
        }
        long sum = 0;
        for(int i = 0; i<len; i++){
            sum += 1L * arr[i] * (i - left[i]) * (right[i] - i);
            sum %= mod;
        }
        return (int)sum;
    }
}