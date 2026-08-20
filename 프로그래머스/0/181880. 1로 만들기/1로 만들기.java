import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int i=0; i<num_list.length; i++){
            int n = num_list[i];
            
            while(true){
                if(n/2==0) break;
                
                if(n%2 == 0){
                    n/=2;
                    answer++;
                }else{
                    n= (n-1)/2;
                    answer++;
                }
                
            }
            
            
        }
        
        return answer;
    }
}