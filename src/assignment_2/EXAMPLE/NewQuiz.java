/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2.EXAMPLE;

/**
 *
 * @author Mark Alexander
 * ID: 20112145
 */
public class NewQuiz {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view);
        MathQuiz mQuiz = new MathQuiz();
        mQuiz.setVisible(true);
    }
    
}
