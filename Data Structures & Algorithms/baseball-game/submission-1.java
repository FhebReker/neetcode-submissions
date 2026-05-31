class Solution {
    public int calPoints(String[] operations) {
        // Initialize stack and score sum
        Stack<Integer> scores = new Stack<>();
        int scoreSum = 0;

        for (String current : operations) {
            // Add previous scores
            if (current.charAt(0) == '+') {
                int score2 = scores.pop();
                int score1 = scores.peek();
                int addedScore = score1 + score2;
                scores.push(score2);
                scores.push(addedScore);

                scoreSum += addedScore;
            }
            else if (current.charAt(0) == 'D') {
                scores.push(2 * scores.peek());
                
                scoreSum += scores.peek();
            }
            else if (current.charAt(0) == 'C') {
                scoreSum -= scores.pop();
            }
            else {
                int newScore = Integer.parseInt(current);
                scores.push(newScore);

                scoreSum += newScore;
            }
        }

        return scoreSum;
    }
}