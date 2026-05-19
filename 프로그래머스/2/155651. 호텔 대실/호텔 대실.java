import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        List<Integer> rooms = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            int start = time(book_time[i][0]);
            int end = time(book_time[i][1]) + 10;

            boolean used = false;

            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j) <= start) {
                    rooms.set(j, end);
                    used = true;
                    break;
                }
            }

            if (!used) {
                rooms.add(end);
            }
        }

        return rooms.size();
    }

    int time(String time) {
        String[] t = time.split(":");

        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);

        return hour * 60 + min;
    }
}