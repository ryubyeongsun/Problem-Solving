import java.util.*;

class Solution {
    char arr[][];
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        arr = new char[storage.length][storage[0].length()];

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {
                arr[i][j] = storage[i].charAt(j);
            }
        }

        for (int i = 0; i < requests.length; i++) {
            String word = requests[i];
            if (word.length() == 2) {
                crain(word.charAt(0));
            } else {
                zige(word.charAt(0));
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != '.') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public void zige(char word) {
        boolean[][] remove = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == word) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length) {
                            remove[i][j] = true;
                            break;
                        }

                        if (arr[nx][ny] == '.') {
                            boolean[][] visit = new boolean[arr.length][arr[0].length];
                            if (removeok(nx, ny, visit)) {
                                remove[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (remove[i][j]) {
                    arr[i][j] = '.';
                }
            }
        }
    }

    public boolean removeok(int x, int y, boolean[][] visit) {
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            return true;
        }
        if (arr[x][y] != '.') {
            return false;
        }
        if (visit[x][y]) {
            return false;
        }
        visit[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (removeok(nx, ny, visit)) {
                return true;
            }
        }

        return false;
    }

    public void crain(char word) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == word) {
                    arr[i][j] = '.';
                }
            }
        }
    }
}