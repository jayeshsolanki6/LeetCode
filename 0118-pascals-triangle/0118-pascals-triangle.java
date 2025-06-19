class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> inList = new ArrayList<>();
            for(int j = 0; j<=i; j++){
                int t = (int)nCr(i, j);
                inList.add(t);
            }
            ans.add(inList);
        }
        return ans;
    }
    public static long nCr(int n, int r){
        long res = 1;
        for(int i = 0; i<r; i++){
            res = res*(n-i);
            res = res/(i+1);
        }
        return res;
    }
}