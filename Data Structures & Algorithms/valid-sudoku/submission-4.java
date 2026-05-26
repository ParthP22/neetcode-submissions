class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] exists = new boolean[9][9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char item = board[i][j];
                if(item == '.'){
                    continue;
                }
                else if(!exists[0][i][item - '1']){
                    exists[0][i][item - '1'] = true;
                }
                else{
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char item = board[j][i];
                if(item == '.'){
                    continue;
                }
                else if(!exists[1][i][item - '1']){
                    exists[1][i][item - '1'] = true;
                }
                else{
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = (i % 3) * 3; j < (i % 3) * 3 + 3; j++){
                for(int k = (i / 3) * 3; k < (i / 3) * 3 + 3; k++){
                    char item = board[k][j];
                    if(item == '.'){
                        continue;
                    }
                    else if(!exists[2][i][item - '1']){
                        exists[2][i][item - '1'] = true;
                    }
                    else{
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
