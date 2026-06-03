class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();

        long total = 1l*len*(len+1)/2;

        int atMostTwo = 0;

        int[] abc = new int[3];
        int left = 0, right = 0;

        while(right < len){
            abc[s.charAt(right)-'a']++;
            while(containsMoreThenTwo(abc)){
                abc[s.charAt(left)-'a']--;
                left++;
            }
            atMostTwo += right-left+1;
            right++;
        }

        int res = (int)(total-atMostTwo);
        return res;
    }
    boolean containsMoreThenTwo(int[] abc){
        int count = 0;
        if(abc[0] > 0) count++;
        if(abc[1] > 0) count++;
        if(abc[2] > 0) count++;

        return count == 3;
    }
}