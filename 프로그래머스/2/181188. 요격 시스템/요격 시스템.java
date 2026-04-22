import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int point = -1;

        for (int i = 0; i < targets.length; i++) {
            int x = targets[i][0];
            int y = targets[i][1];

            if (x >= point) {
                answer++;
                point = y;
            }
        }

        return answer;
    }
}