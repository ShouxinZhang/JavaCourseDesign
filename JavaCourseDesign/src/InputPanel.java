import java.awt.*;
import javax.swing.*;

public class InputPanel extends JPanel {
    private final JLabel wordLabel;
    // GUI components
    private JLabel inputLabel;
    private JTextField inputField;
    private JTextField wordField;

    public InputPanel() {
        // Create the input label and text field
        inputLabel = new JLabel("String: ");
        inputField = new JTextField(20);
        wordLabel = new JLabel("Word: ");
        wordField = new JTextField(20);

        // Create a panel to hold the input components
        setLayout(new GridLayout(2, 1));
        add(inputLabel);
        add(inputField);
        add(wordLabel);
        add(wordField);
    }

    public String getInput() {
        return inputField.getText();
    }
    public String getWord() {
        return wordField.getText();
    }
}
