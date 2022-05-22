/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

public class ViewHandler implements IViewHandler {

    @Override
    public void start() {
        ViewHandler vs = new ViewHandler();
        vs.viewMainMenu();
        vs.viewHelpMenu();
    }

    @Override
    public void viewMainMenu() {
        String menu = "\n-------------------------------"
                + "\n|          Welcome to:        |"
                + "\n|         Who wants to        |"
                + "\n|       be a millionare!      |"
                + "\n-------------------------------";

        System.out.println(menu);
    }

    @Override
    public void viewHelpMenu() {
        String menu
                = "| How to play:"
                + "\n| → You have 10 random questions to answer"
                + "\n| → Answer by typing one reply as A,B,C or D"
                + "\n| → If you answer incorrectly you lose"
                + "\n| → Exit the game by typing 'x' at anytime"
                + "\n| → Reach the end to win $1 MILLION"
                + "\n-------------------------------"
                + "\nEnter your name:";

        System.out.println(menu);
    }

    @Override
    public void viewGameOverWinner() {
        String winner = "\n-------------------------------"
                + "\n|          YOU WON!            |"
                + "\n|         $1 000 000           |"
                + "\n-------------------------------";

        System.out.println(winner);
    }

    @Override
    public void viewGameOverLoser() {
        String loser = "\n-------------------------------"
                + "\n|          YOU LOSE!            |"
                + "\n|         Play Again?           |"
                + "\n-------------------------------";

        System.out.println(loser);
    }

}
