class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        
        q.add(beginWord);
        map.put(beginWord, 1);
        if(set.contains(beginWord)) set.remove(beginWord);
        
        while(!q.isEmpty()){
            String s = q.remove();
            int level = map.get(s);
            if(s.equals(endWord)){
                break;
            }
            List<String> neighbours = find(s, set);
            for(String str : neighbours){
                q.add(str);
                map.put(str, level+1);
            }
        }
        if(map.containsKey(endWord)){
            List<String> list = new ArrayList<>();
            list.add(endWord);
            dfs(endWord, list, beginWord);
        }
        return res;
    }
    void dfs(String s, List<String> list, String b){
        if(s.equals(b)){
            List<String> r = new ArrayList<>(list);
            Collections.reverse(r);
            res.add(r);
            return;
        }
        int level = map.get(s);
        int size = s.length();

        for(int i = 0; i<size; i++){
            char[] arr = s.toCharArray();
            char temp = arr[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(ch == temp) continue;
                arr[i] = ch;
                String str = new String(arr);
                if(map.containsKey(str) && map.get(str) == level-1){
                    list.add(str);
                    dfs(str, list, b);
                    list.remove(list.size()-1);
                }
            }
        }

    }

    List<String> find(String s, Set<String> set){
        int len = s.length();
        char[] arr = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i<len; i++){
            char temp = arr[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c == temp) continue;
                arr[i] = c;
                String str = new String(arr);
                if(set.contains(str)){
                    list.add(str);
                    set.remove(str);
                }
            }
            arr[i] = temp;
        }
        return list;
    }

}