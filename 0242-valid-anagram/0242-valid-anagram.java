class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len != t.length()) return false;
        int[] arr1 = new int[27];
        // int[] arr2 = new int[27];
        // for(int i = 0; i<len; i++){
        //     arr1[s.charAt(i) - 'a']++;
        //     arr2[t.charAt(i) - 'a']++;
        // }
        for(char c: s.toCharArray()){
            arr1[c - 'a']++;
        }
        // for(char c: t.toCharArray()){
        //     arr2[c - 'a']++;
        // }
        // for(int i = 0; i<27; i++){
        //     if(arr1[i] != arr2[i]) return false;
        // }
        for(char c: t.toCharArray()){
            if(arr1[c - 'a'] == 0) return false;
            arr1[c - 'a']--;
        }
        return true;
    }
}