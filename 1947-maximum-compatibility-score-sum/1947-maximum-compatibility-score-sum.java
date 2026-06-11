class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;
        boolean[] vis = new boolean[m];

        return find(0, 0, students, mentors, m, n);
    }
    int find(int i, int mask, int[][] students, int[][] mentors, int m, int n){
        if(i == m) return 0;
        
        int max = Integer.MIN_VALUE;

        for(int j = 0; j<m; j++){
            if(((1 << j) & mask) == 0){
                int score = 0;
                for(int k = 0; k<n; k++){
                    score += ((students[i][k] ^ mentors[j][k]) == 0) ? 1 : 0;
                }
                max = Math.max(max, score + find(i+1, (1 << j)|mask, students, mentors, m, n));
            }
        }

        return max;
    }
}