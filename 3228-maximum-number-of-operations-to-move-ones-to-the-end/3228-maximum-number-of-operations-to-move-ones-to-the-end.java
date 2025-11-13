class Solution {
    public int maxOperations(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int one = 0;
        int op = 0;
        for(int i = 0; i<len; i++){
            if(arr[i] == '1') one++;
            else if(i == len-1 || arr[i+1] == '1') op += one;
        }
        return op;
    }
}