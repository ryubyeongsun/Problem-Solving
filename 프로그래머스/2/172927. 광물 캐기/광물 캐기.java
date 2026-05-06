import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int re[][] = new int[3][3];

        int num = 1;

        for (int i = 0; i < 3; i++) {
            re[i][0] = num;

            for (int j = 1; j < 3; j++) {
                if (re[i][j - 1] / 5 == 0) {
                    re[i][j] = re[i][j - 1] % 5;
                } else {
                    re[i][j] = re[i][j - 1] / 5;
                }
            }

            num *= 5;
        }
        int total = picks[0] + picks[1] + picks[2];
        int max = Math.min(minerals.length, total*5);
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<max; i+=5){
            int hard = 0;
            int dia = 0;
            int iron = 0;
            int stone = 0;
            for(int j=i; j<i+5 && j<max; j++){
                if(minerals[j].equals("diamond")){
                    dia++;
                    hard+=25;
                }else if(minerals[j].equals("iron")){
                    iron++;
                    hard+=5;
                }else if(minerals[j].equals("stone")){
                    stone++;
                    hard+=1;
                }
                
            }
            list.add(new int[]{hard, dia, iron, stone});
        }
        
        Collections.sort(list, (a,b) -> b[0]-a[0]);
        
        for(int i=0; i<list.size(); i++){
            
            int dia = list.get(i)[1];
            int iron = list.get(i)[2];
            int stone = list.get(i)[3];
            
            if(picks[0]>0){
                answer+= dia*re[0][0];
                answer+= iron*re[0][1];
                answer+= stone*re[0][2];
                picks[0]--;
            }else if(picks[1]>0){
                answer+= dia*re[1][0];
                answer+= iron*re[1][1];
                answer+= stone*re[1][2];
                picks[1]--;
            }else if(picks[2]>0){
                answer+= dia*re[2][0];
                answer+= iron*re[2][1];
                answer+= stone*re[2][2];
                picks[2]--;
            }
            
        }
        

        return answer;
    }
}