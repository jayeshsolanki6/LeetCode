class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> in = new ArrayList<>();
            for(int j = 0; j<=i; j++){
                in.add(nCr(i, j));
            }
            list.add(in);
        }
        return list;
    }
    int nCr(int n, int c){
        int ans = 1;
        if(c > n/2) c = n-c;
        for(int i = 1; i<=c; i++){
            ans *= n;
            ans /= i;
            n--;
        }
        return ans;
    }
}