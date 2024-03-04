//problem link
//https://leetcode.com/problems/bag-of-tokens/description/?envType=daily-question&envId=2024-03-04

package Arrays;
import java.util.Arrays;

class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int len = tokens.length;
        int first = 0;
        int last = len - 1;
        int score = 0;
        int maxScore = 0;

        while (first <= last) {
            if (power >= tokens[first]) {
                power -= tokens[first++];
                maxScore = Math.max(maxScore, ++score);
            } else if (score > 0 && first != last) {
                power += tokens[last--];
                score--;
            } else {
                break;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        BagOfTokens bagOfTokens = new BagOfTokens();
        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        int result = bagOfTokens.bagOfTokensScore(tokens, power);
        System.out.println("The maximum score is: " + result);  // Output: The maximum score is: 2
    }
}