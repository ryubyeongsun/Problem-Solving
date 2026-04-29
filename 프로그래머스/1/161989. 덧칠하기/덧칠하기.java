class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] chk = new boolean[n + 1];

        for (int i = 0; i < section.length; i++) {
            chk[section[i]] = true;
        }

        for (int i = 1; i <= n; i++) {

            if (chk[i]) {
                answer++;

                for (int j = i; j < i + m; j++) {
                    if (j > n) break;
                    chk[j] = false;
                }

                i = i + m - 1;
            }
        }

        return answer;
    }
}
