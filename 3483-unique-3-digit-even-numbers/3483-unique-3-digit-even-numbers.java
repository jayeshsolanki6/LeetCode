class Solution {
    public int totalNumbers(int[] digits) {
        int[] hash = new int[10];
        for(int i : digits) hash[i]++;
        int res = 0;
        for(int i = 100; i<999; i += 2){
            if(isPossible(i, hash)) res++;
        }
        return res;
    }

    boolean isPossible(int num, int[] hash){
        int[] freq = new int[10];
        while(num > 0){
            freq[num%10]++;
            num /= 10;
        }
        for(int i = 0; i<10; i++){
            if(hash[i] < freq[i]) return false;
        }
        return true;
    }
}