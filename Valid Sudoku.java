public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = 0; i < board.length; i++){
            HashSet<Character> hs = new HashSet<Character>();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] !='.')
                    if (!hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else    return false;
                else    continue;
            }
        }
        for(int j = 0; j < board[0].length; j++){
            HashSet<Character> hs = new HashSet<Character>();
            for(int i = 0; i < board.length; i++){
                if(board[i][j] !='.')
                    if(!hs.contains(board[i][j]))
                        hs.add(board[i][j]);
                    else
                        return false;
                else    continue;
            }
        }
        
        for(int i = 0; i < board.length; i=i+3){
            for(int j = 0; j < board[i].length; j=j+3){
                HashSet<Character> hs = new HashSet<Character>();
                for(int k = 0; k < 3; k++)
                    for(int l = 0; l < 3; l++)
                        if(board[i+k][j+l] !='.')
                            if (!hs.contains(board[i+k][j+l]))
                                hs.add(board[i+k][j+l]);
                            else   return false;
                        else    continue;
            }
        }
        return true;

    }
}

//better and clear code, running time is same order
class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<bool> > rows(9, vector<bool>(9, false));
        vector<vector<bool> > cols(9, vector<bool>(9, false));
        vector<vector<bool> > blocks(9, vector<bool>(9, false));

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                if (rows[i][c] || cols[j][c] || blocks[i - i % 3 + j / 3][c])
                    return false;
                rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;
            }
        }
        return true;
    }
};
