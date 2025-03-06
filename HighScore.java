
/**
 * A class to represent a the top 2 high scores in a game.
 */
public class HighScore {

    /**
     * The first high score.
     */
    private int first;

    /**
     * The second high score.
     */
    private int second;

    /**
     * Constructor for HighScore class.
     * 
     * @param first  The first high score.
     * @param second The second high score.
     */
    public HighScore() {
        // initialize the high scores to 0
        this.first = 0;
        this.second = 0;
    }

    /**
     * Get the first high score.
     * 
     * @return The first high score.
     */
    public int getFirst() {
        return first;
    }

    /**
     * Get the second high score.
     * 
     * @return The second high score.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Add a score to the high score list.
     * 
     * @param score The score to add.
     */
    public void AddScore(int score) {
        if (score > first) {
            // if the score is higher than the first high score,
            // set the second high score to the first high score and
            // set the first high score to the new score

            this.second = first;
            first = score;

        } else if (score > second) {
            // if the score is higher than the second high score,
            // set the second high score to the new score
            second = score;
        } else {
            // if the score is not high enough, do nothing
            System.out.println("Score not high enough to be added to high score list.");
        }
    }

}
