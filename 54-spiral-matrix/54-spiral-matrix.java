class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r = matrix.length, c = matrix[0].length;
        int minr = 0, minc = 0, maxr = matrix.length-1, maxc = matrix[0].length-1;
        int tne = r*c;
        int cnt = 0;
        while(cnt < tne){
            for(int i = minr, j = minc;j <= maxc && cnt < tne; j++){
                cnt++;
                res.add(matrix[i][j]);
            }
            minr++;
             for(int i = minr, j = maxc; i <= maxr&& cnt < tne; i++){
                cnt++;
                res.add(matrix[i][j]);
            }
            maxc--;
             for(int i = maxr, j = maxc; j >= minc && cnt < tne; j--){
                cnt++;
                res.add(matrix[i][j]);
            }
            maxr--;
            for(int i = maxr, j = minc; i >= minr && cnt < tne; i--){
                cnt++;
                res.add(matrix[i][j]);
            }
            minc++;
        }
              return res;
    }
}