/**
 *
 * @author Mark Alexander
 * @StudentID: 20112145
 *
 */
package assignment_2;

import java.util.Observable;
import java.util.Random;

public class Model extends Observable {

    public Database db;
    public Data data;
    public int ans = 0;
    public String username;

    public Model() {
        this.db = new Database();
        this.db.dbsetup();
    }

    public void checkName(String uname, String pword) {
        this.username = uname;
        this.data = this.db.checkName(uname, pword);

        if (data.loginFlag) {
            this.newQuestion();
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newQuestion() {
        this.data.num1 = getNumber();
        this.data.num2 = getNumber();
        this.ans = this.data.num1 + this.data.num2;
    }

    public int getNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }

    public void quitGame() {
        this.db.quitGame(this.data.currentScore, this.username);
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    void checkAnswer(String answer) {
        try {
            if (answer.equals(this.ans + "")) {
                data.currentScore += 10;
            } else {
                data.currentScore -= 10;
            }
            this.newQuestion();
            this.setChanged();
            this.notifyObservers(this.data);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
