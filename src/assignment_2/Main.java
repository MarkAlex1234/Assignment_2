/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

public class Main {

    public static final IViewHandler vh = new ViewHandler();
    public static final IPlayerInputService ps = new PlayerInputService();
    private static final FileHandler fh = new FileHandler("./resources/PlayerRecords.txt"); //Sets the file location. Can not be changed.

    public static void main(String[] args) {
        vh.start();
        String s = ps.playerInput();
        Player u = fh.checkUser(s);
        Game aGame = new Game(u);
        fh.updateScore(u);
    }

}
