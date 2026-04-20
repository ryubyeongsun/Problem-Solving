import java.util.*;
class Solution {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,-1,1};
    int land[][];
    boolean visit[][];
    int n,m;
    public int solution(int[][] land) {
        this.land=land;
        n = land.length;
        m = land[0].length;
        visit = new boolean[n][m];
        int groupId = 2;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1 && !visit[i][j]){
                    int size = dfs(i,j,groupId);
                    map.put(groupId,size);
                    groupId++;
                }
                
            }
        }
        int max = 0;
        
        for(int i=0; i<m; i++){
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j=0; j<n; j++){
                int id = land[j][i];
                if(id>1 && !set.contains(id)){
                    sum+=map.get(id);
                    set.add(id);
                }
                
            }
            max = Math.max(max, sum);
        }
        
      
        
        return max;
    }
  
    public int dfs(int x, int y, int groupId){
        visit[x][y] = true;
        land[x][y] = groupId;
        int cnt = 1;
        
        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
            
            if(land[nx][ny]!=1 || visit[nx][ny]) continue;
            
            cnt+= dfs(nx,ny,groupId);
            
        }
        
        return cnt;
    }
    
}