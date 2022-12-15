import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class OutputPanel extends JPanel {
    // GUI components
    private JLabel entropyLabel;
    private JTextField entropyField;
    private JTextArea outputWordCountArea; // <-- added
    private int buttonsNumber = 1;
    private JButton[] buttons = new JButton[buttonsNumber];
    private JButton clearButton;
    // List to store calculation history
    private List<Double> calculationHistory = new ArrayList<>();

    public OutputPanel() {
        // Create the clear button and add an action listener
        clearButton = new JButton("Clear History");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearHistory();
            }
        });

        // Create the outputWordCountField text field and set it to not be editable
        outputWordCountArea = new JTextArea(2,10);
        outputWordCountArea.setBackground(getBackground());
        outputWordCountArea.setEditable(false);

        // Create the entropy text field and set it to not be editable
        entropyField = new JTextField(20);
        entropyField.setEditable(false);

        // Set the layout of the panel to a 3x1 grid
        setLayout(new GridLayout(3, 1));

        // Add a black border to the panel
        setBorder(new LineBorder(Color.BLACK));

        // Add the entropy label and text field
        JPanel entropyPanel = new JPanel(new BorderLayout());
        entropyPanel.add(new JLabel("Entropy: "), BorderLayout.LINE_START);
        entropyPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), ""));
        entropyPanel.add(entropyField, BorderLayout.CENTER);
        entropyField.setAlignmentX(Component.CENTER_ALIGNMENT);
        entropyField.setAlignmentY(Component.CENTER_ALIGNMENT);
        entropyField.setBorder(new TitledBorder(new LineBorder(Color.BLACK), ""));
        add(entropyPanel);

        // Add the outputWordCountField text field
        JPanel wordCountPanel = new JPanel();
        wordCountPanel.add(new JLabel("WordCount: "));
        wordCountPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), ""));
        wordCountPanel.add(outputWordCountArea);
        outputWordCountArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputWordCountArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(wordCountPanel);

        // Create a new panel for the clear button
        JPanel clearButtonPanel = new JPanel(new FlowLayout());
        clearButtonPanel.setPreferredSize(new Dimension(100, 100));
        // Add the clear button to the panel
        clearButtonPanel.add(clearButton);
        clearButtonPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), ""));

        // Set the preferred size of the clear button to be half the width of the panel and the same height as the button
        //clearButton.setPreferredSize(new Dimension(clearButtonPanel.getWidth() / 4, clearButton.getHeight()/4));
        add(clearButtonPanel);
        clearButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButtonPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    // Define the setWordCount() method
    public void setWordCount(int wordCount) {
        outputWordCountArea.setText(Integer.toString(wordCount));
    }

    public void setEntropy(double entropy) {
        // Add the entropy value to the calculation history
        calculationHistory.add(entropy);

        entropyField.setText(String.format("%.2f", entropy));
    }

    public void clearHistory() {
        // Clear the calculation history and the entropy and outputWordCountField fields
        calculationHistory.clear();
        entropyField.setText("");
        outputWordCountArea.setText(""); // <-- added
    }

    public void setColor(Color myColor) {
        buttons[0] = clearButton;
        for (int i = 0; i < buttonsNumber; i++) {
            buttons[i].setBackground(myColor);
        }
    }
    public void displayInputString(String inputString, String inputWord) {
        int count = 0;
        int index = inputString.indexOf(inputWord);
        while (index != -1) {
            count++;
            index = inputString.indexOf(inputWord, index + 1);
        }

        outputWordCountArea.setText("The input word appears " + count + " times in the input string.");
    }
}
