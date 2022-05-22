/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

public abstract class Player {

    private String username;
    private int currentScore = 0;
    private int highScore = 0;

    public Player(String un, int cs, int hs) {
        this.username = un;
        this.currentScore = cs;
        this.highScore = hs;
    }

    public String getUsername() {
        return username;
    }

    public int getHighScore() {
        if (this.getCurrentScore() > this.highScore) {
            setHighScore(this.getCurrentScore());
            return highScore;
        }
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the currentScore
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * @param currentScore the currentScore to set
     */
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

}
