class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char arr[][] = new char[wallpaper.length][wallpaper[0].length()];

        for (int i = 0; i < arr.length; i++) {
            String word = wallpaper[i];
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = word.charAt(j);
            }
        }

        int endX = 0;
        int endY = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '#') {
                    endX = i + 1;
                }
            }
        }

        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] == '#') {
                    endY = j + 1;
                }
            }
        }

        int startX = 0;
        int startY = 0;

        boolean chk = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '#') {
                    startX = i;
                    chk = true;
                    break;
                }
            }
            if (chk) break;
        }

        boolean chk1 = false;

        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][j] == '#') {
                    startY = j;
                    chk1 = true;
                    break;
                }
            }
            if (chk1) break;
        }

        answer[0] = startX;
        answer[1] = startY;
        answer[2] = endX;
        answer[3] = endY;

        return answer;
    }
}