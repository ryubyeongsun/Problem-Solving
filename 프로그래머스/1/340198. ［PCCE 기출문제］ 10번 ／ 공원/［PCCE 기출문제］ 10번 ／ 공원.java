import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for(int m=0; m<mats.length; m++){
            int n = mats[m];
            for(int i=0; i<park.length; i++){
                for(int j=0; j<park[0].length; j++){
                    if(park[i][j].equals("-1")){
                       if (i+n<=park.length && j+n<= park[0].length) {
                            boolean chk = true;
                            for(int z=i; z<i+n; z++){
                               for(int k=j; k<j+n; k++){
                                    if(!park[z][k].equals("-1")){
                                        chk = false;
                                        break;
                                    }
                                   if(!chk) break;
                               }
                           }
                           if(chk) answer = Math.max(answer, n);
                           
                       }
                       
                    }
                   
                }
                
            }
        }
        
    
        return answer;
    }
  
}