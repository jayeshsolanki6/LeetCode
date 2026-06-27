class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] arr = new StringBuilder[numRows];
        for(int i = 0; i<numRows; i++){
            arr[i] = new StringBuilder();
        }

        boolean inc = false;
        int i = 0;
        for(char c : s.toCharArray()){
            arr[i].append(c);
            if(i == numRows-1 || i == 0) inc = !inc;
            if(inc) i++;
            else i--;
        }

        for(int j = 1; j<numRows; j++){
            arr[0].append(arr[j]);
        }

        return arr[0].toString();

    }
}