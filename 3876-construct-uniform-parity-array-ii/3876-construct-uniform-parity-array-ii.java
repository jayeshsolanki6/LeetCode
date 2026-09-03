class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        
        for(int i : nums1){
            if(i%2 == 1){
                allEven = false;
                if(minOdd > i) minOdd = i;
            } else{
                if(minEven > i) minEven = i;
            }
        }
        
        if(allEven) return true;
        if(minEven - minOdd >= 1) return true;
        return false;
    }
}