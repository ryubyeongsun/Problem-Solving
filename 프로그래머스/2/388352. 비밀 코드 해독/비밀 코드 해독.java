class Solution {
    int n,answer=0;
    int q[][];
    int ans[];
    int arr[] = new int[5];
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        combo(1,0);
        
        
        return answer;
    }
    public void combo(int start, int dep){
        if(dep == 5){
            if(chk()){
                answer++;
            }
            return;
        }
        
        for(int i=start; i<=n; i++){
            arr[dep] = i;
            combo(i+1,dep+1);
        }
        
    }
    public boolean chk(){
        
        for(int i=0; i<q.length; i++){
            int count = 0;
            for(int j=0; j<5; j++){
                for(int k=0; k<arr.length; k++){
                    if(q[i][j] == arr[k]){
                        count++;
                    }
                }
                
            }
            if(count!=ans[i]){
                return false;
            }
        }
        return true;
        
    }
    
}