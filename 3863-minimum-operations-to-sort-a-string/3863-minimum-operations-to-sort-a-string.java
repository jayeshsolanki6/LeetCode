class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        if(s.equals(new String(arr))) return 0;

        int len = arr.length;
        int[] hash = new int[26];
        for(char c : arr){
            hash[c-97]++;
        }
        int unique = 0;

        for(int i : hash){
            if(i > 0) unique++;
        }

        if(len == 2 && unique == 2) return -1;

        if(s.charAt(0) == arr[0] || s.charAt(len-1) == arr[len-1]) return 1;
        
        int ff = hash[arr[0]-97];
        int lf = hash[arr[len-1]-97];

        if(s.charAt(0) == arr[len-1] && s.charAt(len-1) == arr[0] && ff == 1 && lf == 1) return 3;
        return 2;
    }
}