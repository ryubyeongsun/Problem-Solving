class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;
        int answer = 0;

        for (int i = 0; i < diffs.length; i++) {
            right = Math.max(right, diffs[i]);
        }

        while (left <= right) {
            int level = (left + right) / 2;
            long sumtime = 0;

            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                int curtime = times[i];
                int prev = 0;

                if (i > 0) {
                    prev = times[i - 1];
                }

                if (diff <= level) {
                    sumtime += curtime;
                } else {
                    sumtime += (curtime + prev) * (diff - level) + curtime;
                }
            }

            if (sumtime <= limit) {
                answer = level;
                right = level - 1;   
            } else {
                left = level + 1;    
            }
        }

        return answer;
    }
}