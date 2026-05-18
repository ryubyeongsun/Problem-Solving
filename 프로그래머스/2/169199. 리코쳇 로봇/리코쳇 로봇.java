import java.util.*;
class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    char bo[][];

    public int solution(String[] board) {
        int answer = 0;
        bo = new char[board.length][board[0].length()];
        int startX = 0, startY=0;
        int goalX = 0, goalY=0;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                char word = board[i].charAt(j);
                if(word == 'R') {
                    startX = i;
                    startY = j;
                }
                if(word == 'G'){
                    goalX = i;
                    goalY = j;
                }
                bo[i][j] = word;
            }
            
        }
        
        
        return bfs(startX, startY);
    }
    int bfs(int x, int y){
        boolean visit[][] = new boolean[bo.length][bo[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,0});
        visit[x][y]=true;
        
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int clen = cur[2];
            
            if(bo[cx][cy] == 'G') {
                return clen;
            }
            
            for(int d=0; d<4; d++){
                int nx = cx; 
                int ny = cy;
                
                while(true){
                    int nextX = nx + dx[d];
                    int nextY = ny + dy[d];
                    
                    if(nextX<0 || nextY<0 || nextX>=bo.length || nextY>=bo[0].length || bo[nextX][nextY]=='D') break;
                    
                    nx = nextX;
                    ny = nextY;
                    
                }
                
                if(!visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx,ny,clen+1});
                }
                
            }
            
            
        }
        return -1;
    }
}