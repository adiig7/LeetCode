class Solution {
    public boolean exist(char[][] board, String word) {
        int res = 0;
        for(int i = 0; i < board.length; i++)
            for(int j = 0;j < board[i].length; j++)
                res += search(i, j, word, board, word.length(), 0);
        return (res > 0) ? true : false;
        // return res;
    }
    public int search(int i, int j, String word, char[][] board, int size,int idx){
        int res = 0;
        if(i >= 0 && j >= 0 && i < board.length && j < board[i].length && word.charAt(idx) == board[i][j]){
            char temp = word.charAt(idx);
            board[i][j] = '0';
            idx++;
            if(idx == size){
                res = 1;
            }else{
                res+= search(i+1, j, word, board, size, idx);
                res += search(i-1, j, word, board, size, idx);
                res += search(i, j+1, word, board, size, idx);
                res += search(i, j-1, word, board, size, idx);
            }
            board[i][j] = temp;
        }
        return res;
    }
}