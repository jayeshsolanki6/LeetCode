class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // Set<Integer> zeroRow = new HashSet<>();
        // Set<Integer> zeroCol = new HashSet<>();
        // for(int i = 0; i<row; i++){
        //     for(int j = 0; j<col; j++){
        //         if(matrix[i][j] == 0){
        //             zeroRow.add(i);
        //             zeroCol.add(j);
        //         }
        //     }
        // }
        // for(int zR: zeroRow){
        //     for(int i = 0; i<col; i++){
        //         matrix[zR][i] = 0;
        //     }
        // }
        // for(int zC: zeroCol){
        //     for(int i = 0; i<row; i++){
        //         matrix[i][zC] = 0;
        //     }
        // }
        boolean r = false, c = false;
        for(int i = 0; i<row; i++){
            if(matrix[i][0] == 0){
                c = true;
            }
        }
        for(int i = 0; i<col; i++){
            if(matrix[0][i] == 0){
                r = true;
            }
        }

        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(r){
            for(int i = 0; i<col; i++){
                matrix[0][i] = 0;
            }
        }

        if(c){
            for(int i = 0; i<row; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}