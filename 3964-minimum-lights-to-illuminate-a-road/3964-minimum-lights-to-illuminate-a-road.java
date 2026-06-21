class Solution {
    public int minLights(int[] lights) {
        int len = lights.length;
        int[] temp = new int[len];
        for(int i = 0; i<len; i++){
            if(lights[i] > 0){
                int left = Math.max(0, i-lights[i]);
                temp[left] += 1;
                if(i+lights[i]+1 < len){
                    int right = i+lights[i]+1;
                    temp[right] -= 1;
                }
            }

        }

        int res = 0;
        int curr = 0, sum = 0;
        for(int i = 0; i<len; i++){
            sum += temp[i];
            if(sum <= 0) curr++;
            else{
                res += Math.ceil(curr/3.0);
                curr = 0;
            }
        }
        if(curr > 0){
            res += Math.ceil(curr/3.0);
        }
        return res;
    }
}