class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);
        int len = beginWord.length();
        int res = 0;

        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i = 0; i<size; i++){
                String sb = q.remove();
                if(sb.equals(endWord)) return res;
                for(int j = 0; j<len; j++){
                    char[] arr = sb.toCharArray();
                    char pre = arr[j];
                    for(char c = 'a'; c<='z'; c++){
                        arr[j] = c;
                        String newStr = new String(arr);
                        if(set.contains(newStr)){
                            q.add(newStr);
                            set.remove(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }
} 