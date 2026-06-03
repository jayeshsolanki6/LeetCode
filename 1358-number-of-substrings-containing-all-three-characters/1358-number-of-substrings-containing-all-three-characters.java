class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length();

        int[] abc = new int[3];
        int res = 0;
        int left = 0, right = 0;

        while(right < len){
            abc[s.charAt(right)-'a']++;
            while(contains(abc)){
                res += len-right;
                abc[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }

        return res;
    }
    boolean contains(int[] abc){
        return abc[0] > 0 && abc[1] > 0 && abc[2] > 0;
    }
}