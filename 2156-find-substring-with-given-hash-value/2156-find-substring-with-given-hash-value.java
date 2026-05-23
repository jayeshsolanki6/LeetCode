class Solution {
    
    public String subStrHash(String s, int power, int mod, int k, int hashValue) {
        int len = s.length();
        int[] base = new int[len];
        int[] exp = new int[len];

        base[len-1] = (s.charAt(len-1) - 'a' + 1)%mod;

        for(int i = len-2; i>=0; i--){
            int ch = s.charAt(i) - 'a' + 1;
            base[i] = (int)(((1l*base[i+1]*power)%mod + ch)%mod);
        }

        exp[0] = 1;
        for(int i = 1; i<len; i++){
            exp[i] = (int)((1l*exp[i-1]*power)%mod);
        }

        for(int i = 0; i<=len-k; i++){
            int hash = 0;
            if(i+k == len) hash = base[i];
            else{
                hash = (int)((base[i] - 1l*base[i+k]*exp[k]%mod + mod) % mod);
            }
            if(hash == hashValue){
                return s.substring(i, i+k);
            }
        }
        return "";
    }

}