class Solution {
    List<Integer> list;
    public List<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int t = 0, b = n-1;
        int l = 0, r = m-1;

        while(t <= b && l <= r){
            for(int i = l; i<=r; i++){
                list.add(matrix[t][i]);
            }
            t++;
            if(b < t) break;
            for(int i = t; i<=b; i++){
                list.add(matrix[i][r]);
            }
            r--;
            if(r < l) break;
            for(int i = r; i>=l; i--){
                list.add(matrix[b][i]);
            }
            b--;
            if(b < t) break;
            for(int i = b; i>=t; i--){
                list.add(matrix[i][l]);
            }
            l++;
            if(r < l) break;
        }
        return list;
    }

}