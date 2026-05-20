import java.util.*;

class Solution {
    char[][] map;
    boolean[][] visit;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();

        map = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !visit[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        visit[x][y] = true;
        q.offer(new int[]{x, y});

        int sum = map[x][y] - '0';

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (visit[nx][ny] || map[nx][ny] == 'X') continue;

                visit[nx][ny] = true;
                sum += map[nx][ny] - '0';

                q.offer(new int[]{nx, ny});
            }
        }

        return sum;
    }
}