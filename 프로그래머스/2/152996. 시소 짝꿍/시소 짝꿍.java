import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
       
        Arrays.sort(weights);
    //1:1 1:2 2:3 3:4
        
        for(int w : weights){
            
            if(map.containsKey(w)){
               answer+=map.get(w);
                map.put(w, map.get(w)+1);
                
            } 
            
            if(w%2==0 && map.containsKey(w/2)) answer+=map.get(w/2);
            
            if((w*2)%3==0 && map.containsKey(w*2/3) ) answer+=map.get(w*2/3);
            
            if((w*3)%4==0 && map.containsKey(w*3/4) ) answer+=map.get(w*3/4);
            
            if(!map.containsKey(w)){
                map.put(w,1);
            }
            
        }
        
        
        return answer;
    }
}