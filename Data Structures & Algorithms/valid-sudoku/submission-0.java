class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] exists = new boolean[3][9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(exists[0][i][board[i][j] - '1']){
                    return false;
                }
                else{
                    exists[0][i][board[i][j] - '1'] = true;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                if(exists[1][i][board[j][i] - '1']){
                    return false;
                }
                else{
                    exists[1][i][board[j][i] - '1'] = true;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = (i / 3) * 3; j < (i / 3) * 3 + 3; j++){
                for(int k = (i % 3) * 3; k < (i % 3) * 3 + 3; k++){
                    if(board[j][k] == '.'){
                        continue;
                    }
                    if(exists[2][i][board[j][k] - '1']){
                        return false;
                    }
                    else{
                        exists[2][i][board[j][k] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
