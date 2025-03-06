import javax.swing.*;

public class GraphicalInterface {
    private final JFrame gameFrame;

    public GraphicalInterface() {
        this.gameFrame = createFrame();
    }

    /**
     * Show the game frame
     */
    public void show() {
        gameFrame.setVisible(true);
    }

    /**
     * Create a new JFrame
     * 
     * @return JFrame
     */
    private static JFrame createFrame() {
        // Create a new JFrame
        JFrame frame = new JFrame("Wumpus Game");

        // Set the default close operation to exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame in pixels
        frame.setSize(500, 600);

        return frame;
    }

    public JDialog createDialog(String title) {
        var dialog = new JDialog(gameFrame, title, true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(gameFrame);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        return dialog;
    }
}
