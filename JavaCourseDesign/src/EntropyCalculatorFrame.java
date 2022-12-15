import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class EntropyCalculatorFrame extends JFrame implements ActionListener {
    // GUI components
    private InputPanel inputPanel;
    private OutputPanel outputPanel;
    private JButton calculateButton;
    private JPanel comboBoxPanel;
    private JButton saveButton;
    private JButton wordCountButton;
    private JComboBox comboBox;

    public EntropyCalculatorFrame() {
        // Set the frame's title
        super("Entropy Calculator");

        // Create the input and output panels
        inputPanel = new InputPanel();
        outputPanel = new OutputPanel();

        // Create to calculate, change color, and save buttons and add action listeners
        calculateButton = new JButton("Calculate Entropy");
        calculateButton.addActionListener(this);
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        wordCountButton = new JButton("Word Count");
        wordCountButton.addActionListener(this);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(wordCountButton);

        // Create a combo box and add the labels for the buttons to it
        comboBox = new JComboBox();
        comboBox.addActionListener(this);
        comboBox.addItem("Change Color");
        comboBox.addItem("Change Button Color1");
        comboBox.addItem("Change Button Color2");
        buttonPanel.add(comboBox);

        buttonPanel.add(saveButton);

        // Add the input and output panels to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(outputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame's size and make it visible
        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        // Check if the calculate button was clicked
        if (e.getSource() == calculateButton) {
            // Get the input string from the input panel
            String input = inputPanel.getInput();
            System.out.println("202013140018");
            // Calculate the entropy of the input string
            double entropy = calculateEntropy(input);

            // Set the entropy in the output panel
            outputPanel.setEntropy(entropy);
        } else if (e.getSource() == wordCountButton) {
            // Get the input string from the input panel
            String input = inputPanel.getInput();
            String word = inputPanel.getWord();
            outputPanel.displayInputString(input,word);
        }
        else if (e.getSource() == comboBox) {
            // Get the selected item from the combo box
            String selectedItem = (String) comboBox.getSelectedItem();

            // Handle the selection of the "Change Color" item
            if (selectedItem.equals("Change Button Color1")) {
                // Prompt the user to enter a new background color
                Color newColor = JColorChooser.showDialog(this, "Choose Background Color", outputPanel.getBackground());

                // Set the new color as the background color of the output panel
                if (newColor != null) {
                    outputPanel.setBackground(newColor);
                    outputPanel.setColor(newColor);
                }
            }
            // Handle the selection of the "Change Button Color" item
            else if (selectedItem.equals("Change Button Color2")) {
                // Prompt the user to enter a new button color
                Color newColor = JColorChooser.showDialog(this, "Choose Button Color", calculateButton.getBackground());
                // Set the new color as the background color of all buttons
                if (newColor != null) {
                    changeButtonColor(newColor);
                }
            }
        } else if (e.getSource() == saveButton) {
            // Get the input string from the input panel
            String input = inputPanel.getInput();

            // Save the input string to a file or database
            saveInput(input);
        }
    }


        private void changeButtonColor(Color color) {
        calculateButton.setBackground(color);
        saveButton.setBackground(color);
        wordCountButton.setBackground(color);
    }

    private void saveInput(String input) {
        // Create a File object for the output file
        File outputFile = new File("input.txt");

        // Write the input string to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(input);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    private double calculateEntropy(String input) {
        Compute informationString=new Compute(input);
        double entropy=informationString.calculateEntropy();
        return entropy;
    }
    public static int calculateWordCount(String input) {
        // Split the input string into an array of words
        String[] words = input.split("\\s+");

        // Return the length of the array
        return words.length;
    }
}


