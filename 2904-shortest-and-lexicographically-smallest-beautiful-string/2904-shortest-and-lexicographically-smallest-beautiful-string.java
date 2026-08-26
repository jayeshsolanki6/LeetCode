class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;
        int i = 0;
        for(int j = 0; j<len; j++){
            if(s.charAt(j) == '1') cnt++;

            if(cnt == k){
                while(cnt == k){
                    if(s.charAt(i) == '1'){
                        cnt--;
                    }
                    i++;
                }
                list.add(s.substring(i-1, j+1));
            }
        }
        if(list.size() == 0) return "";
        Collections.sort(list, (a, b) -> (
            (a.length() == b.length()) ? a.compareTo(b) : a.length() - b.length())
        );
        return list.get(0);
    }
}