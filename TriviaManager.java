import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A class to provide manage trivia questions and answers.
 */
public class TriviaManager {

    private final GraphicalInterface gui;
    private final GameControl gameControl;

    /**
     * Constructor for TriviaManager class.
     * 
     * @param gui The graphical interface to use.
     */
    public TriviaManager(GraphicalInterface gui, GameControl gameControl) {
        this.gui = gui;
        this.gameControl = gameControl;
    }

    /**
     * Ask a trivia question.
     */
    public void askTriviaQuestion() {
        var dialog = gui.createDialog("Trivia");

        // Create a panel to hold the question and answer options
        var panel = new JPanel();
        dialog.add(panel);

        // Add the question
        panel.add(new JLabel("What is 9 + 10?"));

        // Create answer options
        var option1 = new JRadioButton("19");
        var option2 = new JRadioButton("21");
        var option3 = new JRadioButton("20");
        var option4 = new JRadioButton("22");

        // Add answer options to a group to allow only one selection
        var group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        // Add answer options to the panel
        panel.add(option1);
        panel.add(option2);
        panel.add(option3);
        panel.add(option4);

        // Add a submit button
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(_ -> {
            // check if the answer is correct
            if (option2.isSelected()) {
                JOptionPane.showMessageDialog(panel, "Correct!");
                gameControl.triviaAnswered(true);
            } else {
                JOptionPane.showMessageDialog(panel, "Incorrect!");
                gameControl.triviaAnswered(false);
            }

            // close the dialog
            dialog.dispose();
        });

        // Add a window listener to handle closing the dialog
        // We need to handle the case when the user closes the dialog without answering
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (option2.isSelected()) {
                    gameControl.triviaAnswered(true);
                } else {
                    gameControl.triviaAnswered(false);
                }
            }
        });

        dialog.setVisible(true);
    }

}
