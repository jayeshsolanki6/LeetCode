class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.charAt(0) != str2.charAt(0)) return "";
        String x = str1 + str2;
        String y = str2 + str1;
        if(!x.equals(y)) return "";
        int a = str1.length();
        int b = str2.length();
        int gcd = gcd(a, b);
        return str1.substring(0, gcd);
    }
    int gcd(int a, int b){
        if(a == 0 || b == 0) return a+b;
        return gcd(b, a%b);
    }
}