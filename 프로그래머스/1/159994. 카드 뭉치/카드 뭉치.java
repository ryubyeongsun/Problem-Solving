class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        boolean an = true;

        int firstcard = 0;
        int secondcard = 0;

        for (int i = 0; i < goal.length; i++) {

            String word = goal[i];

            if (firstcard < cards1.length && word.equals(cards1[firstcard])) {
                firstcard++;
            }
            else if (secondcard < cards2.length && word.equals(cards2[secondcard])) {
                    secondcard++;
               
            }
            else {
                return "No";
            }
            
        }



        return "Yes";
    }
}