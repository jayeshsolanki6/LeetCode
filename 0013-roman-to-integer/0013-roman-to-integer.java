class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> rom = new HashMap<>();
        rom.put('I', 1);
        rom.put('V', 5);
        rom.put('X', 10);
        rom.put('L', 50);
        rom.put('C', 100);
        rom.put('D', 500);
        rom.put('M', 1000);
        int ans = 0;
        int len = s.length();
        for(int i = 0; i<len-1; i++){
            if(rom.get(s.charAt(i)) < rom.get(s.charAt(i+1))){
                ans -= rom.get(s.charAt(i));
            } else{
                ans += rom.get(s.charAt(i));
            }
        }
        ans += rom.get(s.charAt(len-1));
        return ans;
    }
}