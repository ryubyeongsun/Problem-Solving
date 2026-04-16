class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int endtime = 0;

        for (int i = 0; i < schedules.length; i++) {
            int min = schedules[i] % 100 + 10;
            int hour = schedules[i] / 100 + min / 60;
            int min2 = min % 60;

            endtime = hour * 100 + min2;

            boolean chk = true;

            for (int j = 0; j < 7; j++) {
                int day = (startday + j - 1) % 7 + 1;

                if (day == 6 || day == 7) continue;

                if (timelogs[i][j] > endtime) {
                    chk = false;
                    break;
                }
            }

            if (chk) answer++;
        }

        return answer;
    }
}