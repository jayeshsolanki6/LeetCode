class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int one = 0, zero = 0;
        for(char c : arr){
            if(c == '0') zero++;
            else one++;
        }
        int n = strs.length;
        boolean[] res = new boolean[n];
        Arrays.fill(res, true);

        for(int i = 0; i<n; i++){
            char[] temp = strs[i].toCharArray();
            int o = 0, z = 0;
            for(char c : temp){
                if(c == '0') z++;
                else if(c == '1') o++;
            }
            if(o > one || z > zero){
                res[i] = false;
                continue;
            }
            int remO = one-o;
            int remZ = zero-z;

            for(int j = 0; j<len; j++){
                if(temp[j] == '?'){
                    if(remZ > 0){
                        temp[j] = '0';
                        remZ--;
                    } else{
                        temp[j] = '1';
                        remO--;
                    }
                }
            }

            if(remZ > 0 || remO > 1) {
                res[i] = false;
                continue;
            }
            int eo = 0;
            for(int j = 0; j<len; j++){
                if(arr[j] == '0' && temp[j] == '1'){
                    if(eo > 0) eo--;
                    else{
                        res[i] = false;
                        break;
                    }
                } else if(arr[j] == '1' && temp[j] == '0'){
                    eo++;
                }
            }
            if(eo > 0) res[i] = false;
        }
        return res;
    }
}