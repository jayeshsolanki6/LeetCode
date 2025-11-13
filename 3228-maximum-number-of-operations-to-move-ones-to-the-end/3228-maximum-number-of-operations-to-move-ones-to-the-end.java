class Solution {
    public int maxOperations(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[] pre = new int[len];
        int one = 0;
        for(int i = 0; i<len; i++){
            if(arr[i] == '1') one++;
            else pre[i] = one;
        }
        int op = 0;
        for(int i = len-1; i>0; i--){
            if(arr[i] == '0'){
                if(arr[i-1] == '0'){
                    continue;
                }
                op += pre[i];
            }
        }
        return op;
    }
}