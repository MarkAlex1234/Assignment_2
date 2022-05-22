/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

public class PlayerService extends Player implements IPlayerService {

    public PlayerService(String un, int cs, int hs) {
        super(un, cs, hs);
        this.setUsername(un);
        this.setCurrentScore(cs);
        this.setHighScore(hs);
    }

    @Override
    public Player createPlayer(String s, int i, int j) {
        Player player = new PlayerService(s, i, j);
        return player;
    }
}
