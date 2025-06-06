class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int len = words.length;
        for(int i = 0; i<len; i++){
            String s = words[i];
            int l = s.length();
            for(int j = 0; j<l; j++){
                if(s.charAt(j) == x){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}