class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        for(int i = 0; i < matrix.length; i++){
            
              if(i != matrix.length-1 && target >= matrix[i+1][0]) 
                  continue;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}