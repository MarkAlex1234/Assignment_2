/**
 *
 * @author Mark Alexander
 * ID: 20112145
 */
package assignment_2;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements Observer {

    public LoginPanel loginPanel = new LoginPanel();
    private JPanel calcPanel = new JPanel();
    private JPanel optionPanel = new JPanel();

    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);

    private JLabel firstNumber = new JLabel();
    private JLabel secondNumber = new JLabel();
    private JLabel additionLabel = new JLabel("+");

    private JButton nextButton = new JButton("Next");
    private JButton quitButton = new JButton("Quit");
    private JButton mainMenuButton = new JButton("Main Menu");

    private JButton aButton = new JButton("A");
    private JButton bButton = new JButton("B");
    private JButton cButton = new JButton("C");
    private JButton dButton = new JButton("D");

    public JTextField calcSolution = new JTextField(10);

    public JFrame loginFrame = new JFrame("Game - Login");

    private boolean started = false;

    public View() {
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400,300);
        loginFrame.setResizable(false);
        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
    }

    public void startQuiz() {

        loginFrame.setVisible(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        //Question Panel
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calcSolution);
        calcPanel.add(nextButton);
        calcPanel.add(quitButton);
        calcPanel.add(mainMenuButton);

        //Option Panel
        optionPanel.add(aButton);
        optionPanel.add(bButton);
        optionPanel.add(cButton);
        optionPanel.add(dButton);

        this.getContentPane().removeAll();
        this.add(calcPanel, BorderLayout.CENTER);
        this.add(optionPanel, BorderLayout.SOUTH);
        //this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    public void setQuestion(int num1, int num2) {
        firstNumber.setText(num1 + "");
        secondNumber.setText(num2 + "=");
        calcSolution.setText("");
        calcPanel.repaint();
    }

    public void addActionListener(ActionListener listener) {
        //Login Panel Buttons
        this.loginPanel.loginButton.addActionListener(listener);
        this.loginPanel.exitButton.addActionListener(listener);
        
        //Help Menu Buttons
        
        
        //Gameover Buttons
        
        
        //Quit Buttons
        
        this.nextButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
        this.mainMenuButton.addActionListener(listener);
        this.aButton.addActionListener(listener);
        this.bButton.addActionListener(listener);
        this.cButton.addActionListener(listener);
        this.dButton.addActionListener(listener);
    }

    private void quitGame(int score) {
        JPanel quitPanel = new JPanel();
        JLabel scoreLabel = new JLabel("Your score: " + score);
        quitPanel.add(scoreLabel);
        this.getContentPane().removeAll();
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if (!data.loginFlag) {
            this.loginPanel.unInput.setText("");
            this.loginPanel.pwInput.setText("");
            this.loginPanel.messageLabel.setText("Invalid username and/or password");
        } else if (!this.started) {
            this.startQuiz();
            this.started = true;
            this.setQuestion(data.num1, data.num2);
        } else if (data.quitFlag) {
            this.quitGame(data.currentScore);
        } else {
            this.setQuestion(data.num1, data.num2);
        }
    }
}
