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
// class Solution {
// public:
//     void solve(vector<vector<char>>& board) {
//         if (board.empty()) return;
//         int n = board.size();
//         int m = board[0].size();
//         // Top-most line
//         for (int j = 0; j < m; ++j)
//             if (board[0][j] == 'O')
//                 DFS(board, 0, j);
//         // Right-most column
//         for (int i = 1; i < n; ++i)
//             if (board[i][m-1] == 'O')
//                 DFS(board, i, m - 1);
//         // Bottom-most line
//         for (int j = 0; j < m - 1; ++j)
//             if (board[n-1][j] == 'O')
//                 DFS(board, n - 1, j);
//         // Left-most column
//         for (int i = 1; i < n - 1; ++i)
//             if (board[i][0] == 'O')
//                 DFS(board, i, 0);
//         // Change interior 'O's to 'X's meanwhile restoring '#'s to 'O's
//         for (auto& vec: board)
//             for (char& c : vec)
//                 if (c == 'O')
//                     c = 'X';
//                 else if (c == '#')
//                     c = 'O';
//     }

//     void DFS(vector<vector<char>>& board, int i, int j) {
//         board[i][j] = '#';
//         if (i - 1 >= 0 && board[i-1][j] == 'O')
//             DFS(board, i - 1, j);
//         if (j + 1 < board[0].size() && board[i][j+1] == 'O')
//             DFS(board, i, j + 1);
//         if (i + 1 < board.size() && board[i+1][j] == 'O')
//             DFS(board, i + 1, j);
//         if (j - 1 >= 0 && board[i][j-1] == 'O')
//             DFS(board, i, j - 1);
//     }

//     void BFS(vector<vector<char>>& board, int row, int col) {
//         board[row][col] = '#';
//         queue<pair<int, int>> Q;
//         Q.push(make_pair(row, col));
//         while (!Q.empty()) {
//             int i = Q.front().first;
//             int j = Q.front().second;
//             Q.pop();
//             if (i - 1 >= 0 && board[i-1][j] == 'O') {
//                 board[i-1][j] = '#';
//                 Q.push(make_pair(i - 1, j));
//             }
//             if (j + 1 < board[0].size() && board[i][j+1] == 'O') {
//                 board[i][j+1] = '#';
//                 Q.push(make_pair(i, j + 1));
//             }
//             if (i + 1 < board.size() && board[i+1][j] == 'O') {
//                 board[i+1][j] = '#';
//                 Q.push(make_pair(i + 1, j));
//             }
//             if (j - 1 >= 0 && board[i][j-1] == 'O') {
//                 board[i][j-1] = '#';
//                 Q.push(make_pair(i, j - 1));
//             }
//         }
//     }
// };
