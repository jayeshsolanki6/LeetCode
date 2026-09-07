class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        char[] arr = new char[Math.max(m, n)];
        int i = m-1, j = n-1, k = arr.length-1;
        boolean carry = false;
        while(i >= 0 && j >= 0){
            char x = a.charAt(i--);
            char y = b.charAt(j--);
            if(x == '0' && y == '0'){
                if(carry){
                    arr[k] = '1';
                    carry = false;
                }else {
                    arr[k] = '0';
                }
            } else if((x == '0' && y == '1') || (x == '1' && y == '0')){
                if(carry){
                    arr[k] = '0';
                } else{
                    arr[k] = '1';
                }
            } else {
                if(carry){
                    arr[k] = '1';
                } else{
                    arr[k] = '0';
                    carry = true;
                }
            }
            k--;
        }
        while(i >= 0){
            char c = a.charAt(i--);
            if(carry){
                if(c == '1'){
                    arr[k--] = '0';
                } else{
                    arr[k--] = '1';
                    carry = false;
                }
            } else{
                arr[k--] = c;
            }
            
        }
        while(j >= 0){
            char c = b.charAt(j--);
            if(carry){
                if(c == '1'){
                    arr[k--] = '0';
                } else{
                    arr[k--] = '1';
                    carry = false;
                }
            } else{
                arr[k--] = c;
            }
        }

        return (carry)? "1" + new String(arr) : new String(arr);
    }
}