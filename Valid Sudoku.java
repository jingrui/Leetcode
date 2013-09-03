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
