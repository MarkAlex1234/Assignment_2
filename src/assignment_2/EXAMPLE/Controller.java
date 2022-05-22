package assignment_2.EXAMPLE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Mark Alexander
 * @StudentID: 20112145
 * 
 */
public class Controller implements ActionListener {
    
    public View view;
    public Model model;
    
    
    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "Log in":
                String username = this.view.unInput.getText();
                String password = this.view.pwInput.getText();
                this.model.checkName(username, password);
                break;
            case "Next":
                this.model.checkAnswer(this.view.calcSolution.getText());
                break;
            case "Quit":
                this.model.quitGame();
                break;
            default:
                break;
        }
    }
    
}
