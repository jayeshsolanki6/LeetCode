class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for(int i = 0; i<len-2; i++){
            for(int j = 0; j<len-i-1; j++){
                int num1 = arr[j]-'0';
                int num2 = arr[j+1]-'0';
                arr[j] = (char)((num1+num2)%10);
            }
        }
        return arr[0] == arr[1];
    }
}