class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i = 1; i<=n; i++){
            int aa = i*i;
            for(int j = i+1; j<=n; j++){
                int bb = j*j;
                if(Math.sqrt(aa+bb) == (int)Math.sqrt(aa+bb) && n >= (int)Math.sqrt(aa+bb)){
                    count++;
                }
            }
        }
        return count*2;
    }
}