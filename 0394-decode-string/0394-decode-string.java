class Solution {
    public String decodeString(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        generate(0, s.toCharArray(), len, sb);
        return sb.toString();
    }
    int generate(int i, char[] arr, int len, StringBuilder sb){
        int num = 0;
        while(i < len && arr[i] != ']'){ 
            if(arr[i] >= '0' && arr[i] <= '9'){
                num = num*10 + (arr[i++]-'0');
            } else if(arr[i] == '['){
                StringBuilder currs = new StringBuilder();
                int next = generate(i+1, arr, len, currs);
                sb.repeat(currs, num);
                num = 0;
                i = next+1;
            } else {
                sb.append(arr[i++]);
            }
        }
        return i;
    }
}