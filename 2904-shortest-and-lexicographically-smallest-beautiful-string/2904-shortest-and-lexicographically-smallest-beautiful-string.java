class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;
        int min = Integer.MAX_VALUE;
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
                min = Math.min(min, j-i+2);
                list.add(s.substring(i-1, j+1));
            }
        }
        if(list.size() == 0) return "";
        ArrayList<String> l = new ArrayList<>();
        for(String str : list){
            if(str.length() == min) l.add(str);
        }
        Collections.sort(l);
        return l.get(0);
    }
}