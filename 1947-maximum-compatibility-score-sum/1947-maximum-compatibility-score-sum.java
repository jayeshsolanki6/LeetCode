class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        boolean[] vis = new boolean[m];

        return find(0, vis, students, mentors, m, n);
    }
    int find(int i, boolean[] vis, int[][] students, int[][] mentors, int m, int n){
        if(i == m) return 0;
        
        int max = Integer.MIN_VALUE;

        for(int j = 0; j<m; j++){
            if(!vis[j]){
                vis[j] = true;
                int score = 0;
                for(int k = 0; k<n; k++){
                    score += ((students[i][k] ^ mentors[j][k]) == 0) ? 1 : 0;
                }
                max = Math.max(max, score + find(i+1, vis, students, mentors, m, n));
                vis[j] = false;
            }
        }

        return max;
    }
}