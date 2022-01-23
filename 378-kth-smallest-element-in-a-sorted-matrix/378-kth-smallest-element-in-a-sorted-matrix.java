class Solution {
    // int counter(int[][] matrix, int k, int mid, int rows, int cols){
    //     int count = 0;
    //     int j = cols-1;
    //     for(int i = 0; i < rows; i++){
    //         for(j >= 0; j--){
    //             if(matrix[i][j] <= mid){
    //                 count += j+1;
    //             }
    //         }
    //     }
    //     return count;
    // }
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[rows-1][cols-1];
        while(low < high){
            int mid = ((high-low)/2 + low);
            int count = 0; 
            int j = cols - 1;
            for (int i = 0; i < rows; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += j + 1;
            }
            if(count >= k) high = mid;
            else    low = mid+1;
        }
        return low;
    }
}