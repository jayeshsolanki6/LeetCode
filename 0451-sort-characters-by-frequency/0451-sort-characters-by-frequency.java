class Solution {
    public String frequencySort(String s) {
        // int len = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buc = new List[s.length() + 1];
        for(Map.Entry<Character, Integer> e: mp.entrySet()){
            int freq = e.getValue();
            if(buc[freq] == null){
                buc[freq] = new ArrayList<>();
            }
            buc[freq].add(e.getKey());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = buc.length - 1; i>0; i--){
            if(buc[i] != null){
                for(char c:buc[i]){
                    for(int j = 0; j<i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}