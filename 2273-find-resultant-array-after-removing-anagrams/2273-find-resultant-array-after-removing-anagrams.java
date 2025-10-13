class Solution {
    public List<String> removeAnagrams(String[] words) {
        int len = words.length;
        Stack<String> st = new Stack<>();
        int i = 0;
        while(i < len){
            if(!st.isEmpty() && isAnagram(st.peek(), words[i])) i++;
            else st.push(words[i++]);
        }
        List<String> list = new ArrayList<>();
        for(String s : st){
            list.add(s);
        }
        return list;
    }
    boolean isAnagram(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}