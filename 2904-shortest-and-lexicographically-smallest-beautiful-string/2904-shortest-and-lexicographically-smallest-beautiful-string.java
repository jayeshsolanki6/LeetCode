class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length();
        String res = "";
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
                String str = s.substring(i-1, j+1);
                if(res.length() == 0 || res.length() > str.length()){
                    res = str;
                } else if(res.length() == str.length()){
                    if(str.compareTo(res) < 0){
                        res = str;
                    }
                }

            }
        }
        
        return res;
    }
}