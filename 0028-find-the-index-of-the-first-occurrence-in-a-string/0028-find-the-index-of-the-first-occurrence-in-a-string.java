class Hasher {
    int n;
    int[] hash, pow;
    int mod = (int)1e9 + 9;
    int base = 33;
    Hasher(String s){
        n = s.length();
        hash = new int[n+1];
        pow = new int[n+1];
        pow[0] = 1;
        for(int i = 0; i<n; i++){
            hash[i+1] = (int)((1l*hash[i]*base % mod + (s.charAt(i)-'a'))%mod);
            pow[i+1] = (int)(1l*pow[i]*base%mod);
        }
    }

    int getHash(int l, int r){
        int h = (int)((hash[r+1] - (int)(1l*hash[l]*pow[r-l+1]%mod))%mod);
		return (h+mod)%mod;
    }

}
class Solution {
    
    public int strStr(String haystack, String needle) {
        Hasher s1 = new Hasher(haystack);
        Hasher s2 = new Hasher(needle);
        int l1 = s1.n;
        int l2 = s2.n;

        for(int i = 0; i<=l1-l2; i++){
            if(s1.getHash(i, i+l2-1) == s2.getHash(0, l2-1)) return i;
        }

        return -1;
    }
}