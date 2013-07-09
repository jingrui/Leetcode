public class Solution {
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length == 0)   return;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < visited.length; i++)
            for(int j = 0; j < visited[i].length; j++)
                visited[i][j] = false;
        
        for(int i = 1; i < visited.length-1; i++)
            for(int j = 1; j < visited[i].length-1; j++){
                if ((visited[i][j] == false)&&(board[i][j]=='O')){
                    if(!helper(i,j,board.length-1,board[1].length-1,board,visited))
                        board[i][j] = 'X';
                }
            }
    }
    // true keep 'O'
    public boolean helper(int r, int c, int rlimit, int climit,char[][] board,boolean[][] visited){
        visited[r][c] = true;
        if((r == 0)||(c==0)||(r==rlimit)||(c == climit))
            return true;
        
        boolean ret = false;
        // top
        if((board[r-1][c] == 'O')&&(visited[r-1][c] == false))
            ret = (helper(r-1,c,rlimit,climit,board,visited)||ret);
        // bot
        if((board[r+1][c] == 'O')&&(visited[r+1][c] == false))
            ret = (helper(r+1,c,rlimit,climit,board,visited)||ret);
        // left
        if((board[r][c-1] == 'O')&&(visited[r][c-1] == false))
            ret = (helper(r,c-1,rlimit,climit,board,visited)||ret);
        // right
        if((board[r][c+1] == 'O')&&(visited[r][c+1] == false))
            ret = (helper(r,c+1,rlimit,climit,board,visited)||ret);
       
        if(ret == false)
            board[r][c] = 'X';
        return ret;
    }
}
