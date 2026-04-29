class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<StringBuilder> q = new ArrayDeque<>();
        q.add(new StringBuilder(beginWord));
        if(set.contains(beginWord)) set.remove(beginWord);
        int len = beginWord.length();
        int res = 0;

        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i = 0; i<size; i++){
                StringBuilder sb = q.remove();
                if(sb.toString().equals(endWord)) return res;
                for(int j = 0; j<len; j++){
                    for(int k = 0; k<26; k++){
                        char c = (char)('a' + k);
                        StringBuilder newStr = new StringBuilder(sb);
                        newStr.setCharAt(j, c);
                        if(set.contains(newStr.toString())){
                            q.add(newStr);
                            set.remove(newStr.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }
} 