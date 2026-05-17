class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] exists = new boolean[3][9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(exists[0][i][board[i][j] - '1']){
                        return false;
                    }
                    else{
                        exists[0][i][board[i][j] - '1'] = true;
                    }
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    if(exists[1][i][board[j][i] - '1']){
                        return false;
                    }
                    else{
                        exists[1][i][board[j][i] - '1'] = true;
                    }
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[3*(i/3) + j / 3][3*(i % 3) + j % 3] != '.'){
                    if(exists[2][i][board[3*(i/3) + j / 3][3*(i % 3) + j % 3] - '1']){
                        return false;
                    }
                    else{
                        exists[2][i][board[3*(i/3) + j / 3][3*(i % 3) + j % 3] - '1'] = true;
                    }
                }
            }
        }

        return true;

    }
}
