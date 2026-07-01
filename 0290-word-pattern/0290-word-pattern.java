class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        int len = arr.length;
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();

        for(int i = 0; i<len; i++){
            if(map1.containsKey(arr[i])){
                if(pattern.charAt(i) != map1.get(arr[i])) return false;
            } else{
                map1.put(arr[i], pattern.charAt(i));
            }
            if(map2.containsKey(pattern.charAt(i))){
                if(!map2.get(pattern.charAt(i)).equals(arr[i])) return false;
            } else{
                map2.put(pattern.charAt(i), arr[i]);
            }
        }
        return true;
    }
}