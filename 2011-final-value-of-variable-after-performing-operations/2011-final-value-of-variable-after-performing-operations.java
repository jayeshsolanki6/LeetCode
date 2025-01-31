class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(String s: operations){
            if(s.charAt(1) == '+'){
                X+=1;
            } else{
                X-=1;
            }
        } return X;
    }
}