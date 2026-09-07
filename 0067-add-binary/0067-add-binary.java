class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        
        char[] arr = new char[Math.max(i, j)+2];
        int k = arr.length-1;
        int c = 0;
        
        while(i >= 0 || j >= 0 || c != 0){
            int s = c;

            if(i >= 0){
                s += a.charAt(i--)-'0';
            }
            if(j >= 0){
                s += b.charAt(j--)-'0';
            }

            arr[k--] = (char)('0' + s%2);
            c = s/2;
        }

        if(k == -1) return new String(arr);
        
        return new String(arr, k+1, arr.length-1);
    }
}