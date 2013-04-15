public class Solution {
  public boolean exist(char[][] board, String word) {
      // Start typing your Java solution below
      // DO NOT write main() function
      for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
              if(board[i][j] == word.charAt(0))
                  if(helper(board, i, j, word.substring(1)))
                      return true;
          }
      }
      return false;
  }
  public boolean helper(char[][] board, int r, int c, String word){
      if(word.length() == 0) return true;
      // Up
      if(r > 0 && board[r - 1] [c] == word.charAt(0)){
          char ch = board[r][c];
          board[r][c] = '#';
          if(helper(board, r - 1, c, word.substring(1)))
              return true;
          board[r][c] = ch;
      }
      // Right
      if(c < board[0].length - 1 && board[r] [c + 1] == word.charAt(0)){
          char ch = board[r][c];
          board[r][c] = '#';
          if(helper(board, r, c + 1, word.substring(1)))
              return true;
          board[r][c] = ch;
      }
      // Down
      if(r < board.length - 1 && board[r + 1] [c] == word.charAt(0)){
          char ch = board[r][c];
          board[r][c] = '#';
          if(helper(board, r + 1, c, word.substring(1)))
              return true;
          board[r][c] = ch;
      }
      // Left
      if(c > 0 && board[r] [c - 1] == word.charAt(0)){
          char ch = board[r][c];
          board[r][c] = '#';
          if(helper(board, r, c - 1, word.substring(1)))
              return true;
          board[r][c] = ch;
      }
  
      return false;
  }
}
