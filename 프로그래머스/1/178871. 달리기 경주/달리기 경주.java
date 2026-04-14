import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String n = callings[i];
            
            int a = map.get(n);
            int b = a - 1;
            
            String p = players[b];
            
            players[b] = n;
            players[a] = p;
            
            map.put(n, b);
            map.put(p, a);
        }
        
        return players;
    }
}