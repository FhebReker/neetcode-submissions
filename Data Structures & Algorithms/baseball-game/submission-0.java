class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String current : operations) {
            if (current.charAt(0) == '+') {
                int score2 = scores.pop();
                int score1 = scores.peek();
                int addedScore = score1 + score2;
                scores.push(score2);
                scores.push(addedScore);
            }
            else if (current.charAt(0) == 'D') {
                scores.push(2 * scores.peek());
            }
            else if (current.charAt(0) == 'C') {
                scores.pop();
            }
            else {
                int newScore = Integer.parseInt(current);
                scores.push(newScore);
            }
        }

        int scoreSum = 0;
        while (!scores.isEmpty()) {
            scoreSum += scores.pop();
        }

        return scoreSum;
    }
}