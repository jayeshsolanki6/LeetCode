class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if(bits[len-1] == 1) return false;
        int i = 0;
        while(i<len){
            if(bits[i] == 1) i += 2;
            else i++;
            if(i == len-1) return true;
        }
        return false;
    }
}