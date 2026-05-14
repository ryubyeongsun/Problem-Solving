import java.util.*;
class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    public int solution(String[] maps) {
        int sx=0, sy=0;
        int lx=0, ly=0;
        int ex=0, ey=0;
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                char word = maps[i].charAt(j);
                
                if(word == 'S'){
                    sx = i;
                    sy = j;
                }
                if(word == 'L'){
                    lx = i;
                    ly = j;
                }
                if(word == 'E'){
                    ex = i;
                    ey = j;
                }
            }
        }
    
        int startL = bfs(sx,sy, lx, ly , maps);
        if(startL == -1) return -1;
        
        int end = bfs(lx,ly,ex,ey,maps);
        
        if(end == -1) return -1;
        
        
        
        return startL + end;
    }
    int bfs(int sx, int sy, int ex, int ey, String map[]){
        Queue<int []> q = new LinkedList<>();
        boolean visit[][] = new boolean[map.length][map[0].length()];
        visit[sx][sy] = true;
        q.offer(new int[]{sx,sy,0});
        
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];
            int len = cur[2];
            
            if(x == ex && y == ey) return len;
            
            for(int d=0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                
                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length()) continue;
                
                if(map[nx].charAt(ny) == 'X') continue;
                
                if(visit[nx][ny]) continue;
                
                visit[nx][ny] = true;
                
                q.offer(new int[]{nx,ny,len+1});
            }
            
            
        }
        return -1;
        
    }
}