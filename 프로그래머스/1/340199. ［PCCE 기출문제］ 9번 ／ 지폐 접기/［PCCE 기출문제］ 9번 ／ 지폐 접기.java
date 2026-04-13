class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int a = wallet[0];
        int b = wallet[1];
        int a1 = bill[0];
        int b1 = bill[1];

        while (true) {
            if ((a >= a1 && b >= b1) || (a >= b1 && b >= a1)) {
                break;
            }

            if (a1 > b1) {
                a1 /= 2;
            } else {
                b1 /= 2;
            }

            answer++;
        }

        return answer;
    }
}