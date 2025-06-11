class Solution {
    public int secondHighest(String s) {
        int arr[] = new int[10];
        int len = s.length();
        for(int i = 0; i<len; i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                arr[c - '0'] = 1;
            }
        }
        int count = 0;
        for(int i = 9; i>=0; i--){
            if(arr[i] == 1) count++;
            if(count == 2) return i;
        }
        return -1;
    }
}