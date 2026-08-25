class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        
        int a = arr1.length;
        int b = arr2.length;
        
        
        if(a==b){
            int sum_a = 0;
            int sum_b = 0;
            for(int i=0; i<a; i++){
                sum_a+=arr1[i];
                sum_b+=arr2[i];
            }
            if(sum_a<sum_b){
                answer = -1;
            }else if(sum_a>sum_b){
                answer = 1;
            }else{
                answer = 0;
            }
        }else if(a<b){
            answer=-1;           
        }else{
            answer=1;
        }
        
        
        return answer;
    }
}