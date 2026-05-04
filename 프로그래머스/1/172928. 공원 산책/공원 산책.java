class Solution {
    char park1[][];
    String routes1[][];
    int posX = 0, posY = 0;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        park1 = new char[park.length][park[0].length()];
        routes1 = new String[routes.length][2];

        for (int i = 0; i < routes.length; i++) {
            routes1[i] = routes[i].split(" ");
        }

        for (int i = 0; i < park1.length; i++) {
            for (int j = 0; j < park1[0].length; j++) {
                park1[i][j] = park[i].charAt(j);

                if (park1[i][j] == 'S') {
                  
                    posX = i;
                    posY = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            bfs(posX, posY, routes1[i][0], routes1[i][1]);
        }

        answer[0] = posX;
        answer[1] = posY;

        return answer;
    }

    void bfs(int x, int y, String a, String b) {
        int dist = Integer.parseInt(b);

        int moveX = 0;
        int moveY = 0;

        if (a.equals("N")) {
            moveX = -1;
        } else if (a.equals("S")) {
            moveX = 1;
        } else if (a.equals("W")) {
            moveY = -1;
        } else if (a.equals("E")) {
            moveY = 1;
        }

        int nx = x;
        int ny = y;

        for (int i = 0; i < dist; i++) {
            nx += moveX;
            ny += moveY;

            if (nx < 0 || ny < 0 || nx >= park1.length || ny >= park1[0].length) {
                return;
            }

            if (park1[nx][ny] == 'X') {
                return;
            }
        }

        posX = nx;
        posY = ny;
    }
}