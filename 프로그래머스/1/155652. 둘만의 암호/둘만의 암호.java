import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < skip.length(); i++) {
            char word = skip.charAt(i);
            map.put(word, 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            int count = 0;

            while (count < index) {
                word++;

                if (word > 'z') {
                    word = 'a';
                }

                if (!map.containsKey(word)) {
                    count++;
                }
            }

            answer += word;
        }

        return answer;
    }
}