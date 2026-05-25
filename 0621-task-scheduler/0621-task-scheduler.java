class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0;
        
        int[] freq = new int[26];
        for(char c : tasks){
            maxFreq = Math.max(maxFreq, ++freq[c - 'A']);
        }

        int maxCount = 0;
        for(int f : freq){
            if(f == maxFreq) maxCount++;
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1) + maxCount);
        
    }
}