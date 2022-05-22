/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.util.HashSet;
import java.util.Scanner;

public class Game extends Main {

    private final HashSet<QuizQuestion> questions;
    private final Player aPlayer;
    private static final FileHandler fh = new FileHandler("./resources/PlayerRecords.txt");

    public Game(Player u) {
        this.questions = new HashSet();
        this.aPlayer = u;
        this.doQuestions();
    }

    private void doQuestions() {
        String answer;
        Scanner scan = new Scanner(System.in);
        while (this.questions.size() < 10) { //Generates until there has been 10 Questions
            this.questions.add(new QuizQuestion());

        }

        System.out.println("Enter your answer as [A,B,C,D]. Press 'X' to quit");

        for (QuizQuestion question : this.questions) {
            System.out.println(question.aQuestion);
            do {
                answer = scan.nextLine();
            } while (!this.isValidAnswer(answer));
            if (answer.equalsIgnoreCase("x")) {
                System.out.println("--> Are you sure you want to quit? [Y/N]");
                if (ps.playerInput().equalsIgnoreCase("y")) {
                    break;
                } else{
                    //do nothing
                }

            }
            if (answer.equalsIgnoreCase(question.answer)) {
                this.aPlayer.setCurrentScore(aPlayer.getCurrentScore() + 10);
                System.out.println("Correct!");
            } else {
                this.aPlayer.setCurrentScore(aPlayer.getCurrentScore());
                fh.updateScore(aPlayer);
                vh.viewGameOverLoser();
                playAgain();
            }

        }

        if (aPlayer.getCurrentScore() >= 100) {
            fh.updateScore(aPlayer);
            vh.viewGameOverWinner();
            playAgain();
        }

    }

    private boolean isValidAnswer(String answer) { 
        if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C")
                || answer.equalsIgnoreCase("D") || answer.equalsIgnoreCase("X")) {
            return true;
        } else {
            System.out.println("Error--> Invalid Input. ONLY ANSWER WITH [A,B,C,D] OR X to quit. Try again.");
            return false;
        }
    }

    private void playAgain() {
        System.out.println("Play Again? [Y] OR press any other key to quit");
        if (ps.playerInput().equalsIgnoreCase("y")) {
            main(null);
        } else {
            System.exit(0);
        }
    }
}
