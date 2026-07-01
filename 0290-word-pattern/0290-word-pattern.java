class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        int len = arr.length;
        HashMap<String, Character> map = new HashMap<>();

        for(int i = 0; i<len; i++){
            if(map.containsKey(arr[i])){
                if(pattern.charAt(i) != map.get(arr[i])) return false;
            } else if(map.containsValue(pattern.charAt(i))){
                return false;
            } else{
                map.put(arr[i], pattern.charAt(i));
            }
        }
        return true;
    }
}