import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        int dist[] = new int[y+1];
        Arrays.fill(dist,-1);
        dist[x] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(cur == y) return dist[cur];
            
            int next[] = {cur+n, cur*2, cur*3};
            
            for(int num : next){
                if(num<=y && dist[num]==-1){
                    dist[num] = dist[cur] + 1;
                    q.offer(num);
                }
                
            }
            
            
            
        }
        
        
        
        
        return -1;
    }
}