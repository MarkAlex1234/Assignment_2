/**
 *
 * @author Mark Alexander
 * ID: 20112145
 */
package assignment_2.EXAMPLE;

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
    private JPanel userPanel = new JPanel();
    private JPanel calcPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or password!");

    private JLabel firstNumber = new JLabel();
    private JLabel secondNumber = new JLabel();
    private JLabel additionLabel = new JLabel("+");
    private JButton nextButton = new JButton("Next");
    private JButton quitButton = new JButton("Quit");
    private JButton loginButton = new JButton("Log in");

    private JLabel message = new JLabel("Welcome!", JLabel.CENTER);
    public JTextField calcSolution = new JTextField(10);
    
    private boolean started = false;
    
    public View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        userPanel.add(uName);
        userPanel.add(unInput);
        userPanel.add(pWord);
        userPanel.add(pwInput);
        userPanel.add(loginButton);
        this.add(this.message, BorderLayout.SOUTH);
        this.add(userPanel);
        this.setVisible(true);
    }
    
    public void startQuiz(){
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calcSolution);
        calcPanel.add(nextButton);
        calcPanel.add(quitButton);
        this.getContentPane().removeAll();
        calcPanel.setVisible(true);
        this.add(calcPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void setQuestion(int num1, int num2){
        firstNumber.setText(num1 + "");
        secondNumber.setText(num2 + "=");
        calcSolution.setText("");
        calcPanel.repaint();
    }
    
    public void addActionListener(ActionListener listener){
        this.loginButton.addActionListener(listener);
        this.nextButton.addActionListener(listener);
        this.quitButton.addActionListener(listener);
    }
    
    private void quitGame(int score){
         JPanel quitPanel = new JPanel();
         JLabel scoreLabel = new JLabel("Your score: " + score);
         quitPanel.add(scoreLabel);
         this.getContentPane().removeAll();
         //calcPanel.setVisible(true);
         this.add(quitPanel);
         this.revalidate();
         this.repaint();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if(!data.loginFlag){
            this.unInput.setText("");
            this.pwInput.setText("");
            this.message.setText("Invalid username and/or password");
        } else if (!this.started){
            this.startQuiz();
            this.started = true;
            this.setQuestion(data.num1, data.num2);
        } else if (data.loginFlag){
            this.quitGame(data.currentScore);
        } else {
            this.setQuestion(data.num1, data.num2);
        }
    }
    
}
