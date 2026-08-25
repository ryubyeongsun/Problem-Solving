import java.util.*;
class Solution {
    public int[] solution(int[] num_list, int n) {
        int sum = 0;
        
        for(int i=n-1; i<num_list.length; i++){
            sum++;
        }
        
        int answer[] = new int[sum];
        
        int j=0;
        for(int i = n-1; i<num_list.length; i++){
            
            answer[j]=num_list[i];
            j++;
        }
        
        return answer;
    }
}