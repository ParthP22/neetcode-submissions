class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        bool exists[3][9][9] = {false};

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char curr = board[i][j];
                if(curr != '.'){
                    if(exists[0][i][curr - '1']){
                        return false;
                    }
                    exists[0][i][curr - '1'] = true;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char curr = board[j][i];
                if(curr != '.'){
                    if(exists[1][i][curr - '1']){
                        return false;
                    }
                    exists[1][i][curr - '1'] = true;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = (i % 3) * 3; j < (i % 3) * 3 + 3; j++){
                for(int k = (i / 3) * 3; k < (i / 3) * 3 + 3; k++){
                    char curr = board[j][k];
                    if(curr != '.'){
                        if(exists[2][i][curr - '1']){
                            return false;
                        }
                        exists[2][i][curr - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
};
