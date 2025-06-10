class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int a1 = 0, a2 = s.length();
        for(Integer value : count.values()){
            if(value%2 == 0){
                a2 = Math.min(value, a2);
            } else{
                a1 = Math.max(value, a1);
            }
        }
        return a1-a2;
    }
}