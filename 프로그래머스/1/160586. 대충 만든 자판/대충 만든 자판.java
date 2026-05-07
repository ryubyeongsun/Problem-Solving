import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer =new int [targets.length];
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            String word = keymap[i];
            for(int j=0; j<word.length(); j++){
                char a = word.charAt(j);
                if(!map.containsKey(a) ){
                    map.put(a,j+1);
                }else{
                    if(map.get(a)>j+1){
                        map.put(a,j+1);
                    }
                }
            }
        }
               
        for(int i=0; i<targets.length; i++){
            int count = 0;
            boolean chk = true;
            String word = targets[i];
            for(int j=0; j<word.length(); j++){
                if(map.containsKey(word.charAt(j))){
                    count += map.get(word.charAt(j));
                }else{
                    chk = false;
                }
            }
            if(!chk) count = -1;
            answer[i] = count;
        }
        
        
        
        return answer;
    }
}