package gui_swing_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SwingEventWindow extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;
    private JRadioButton totalButton;
    private JRadioButton averageButton;
    private JRadioButton maximumButton;
    private JRadioButton minimumButton;
    private JButton calculateButton;
    private ButtonGroup operationButtonGroup;

    public SwingEventWindow() {

        setTitle("Swing Event Window");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1)); // 5 rows and 1 column

        JLabel inputLabel = new JLabel("Enter a string of numbers separated by commas:");
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER); // Set the alignment to CENTER
        inputField = new JTextField(20);
        inputField.setPreferredSize(new Dimension(inputField.getPreferredSize().width, 100));


        Font inputFont = inputField.getFont();
        Font newFont = inputFont.deriveFont(Font.BOLD, 16);
        inputField.setFont(newFont);
        inputField.setHorizontalAlignment(JTextField.CENTER);

        outputArea = new JTextArea(10, 20);
        Font outputFont = outputArea.getFont();
        Font newOutputFont = outputFont.deriveFont(Font.BOLD, 16);
        outputArea.setFont(newOutputFont);
        outputArea.setAlignmentX(Component.CENTER_ALIGNMENT);


        totalButton = new JRadioButton("Total");
        averageButton = new JRadioButton("Average");
        maximumButton = new JRadioButton("Maximum");
        minimumButton = new JRadioButton("Minimum");
        calculateButton = new JButton("Calculate");


        operationButtonGroup = new ButtonGroup();
        operationButtonGroup.add(totalButton);
        operationButtonGroup.add(averageButton);
        operationButtonGroup.add(maximumButton);
        operationButtonGroup.add(minimumButton);


        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setLayout(new GridLayout(1, 4));
        radioButtonPanel.add(totalButton);
        radioButtonPanel.add(averageButton);
        radioButtonPanel.add(maximumButton);
        radioButtonPanel.add(minimumButton);


        mainPanel.add(inputLabel);
        mainPanel.add(inputField);
        mainPanel.add(radioButtonPanel);
        mainPanel.add(calculateButton);
        mainPanel.add(outputArea);


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });


        setContentPane(mainPanel);
        setVisible(true);
    }

    private ArrayList<Double> parseInput(String input) {
        ArrayList<Double> numbers = new ArrayList<>();
        String[] numberTokens = input.split(",");
        try {
            for (String numberToken : numberTokens) {
                double number = Double.parseDouble(numberToken.trim());
                numbers.add(number);
            }
            return numbers;
        } catch (NumberFormatException e) {
            return null; 
        }
    }

    private void calculate() {
        String input = inputField.getText();
        ArrayList<Double> numbers = parseInput(input);
        if (numbers != null) {
            if (totalButton.isSelected()) {
                double total = Excel.calculateTotal(numbers);
                outputArea.setText("Total: " + total);
            } else if (averageButton.isSelected()) {
                double average = Excel.calculateAverage(numbers);
                outputArea.setText("Average: " + average);
            } else if (maximumButton.isSelected()) {
                double maximum = Excel.calculateMaximum(numbers);
                outputArea.setText("Maximum: " + maximum);
            } else if (minimumButton.isSelected()) {
                double minimum = Excel.calculateMinimum(numbers);
                outputArea.setText("Minimum: " + minimum);
            }
        } else {
            outputArea.setText("Invalid input. Please enter a valid string of numbers.");
        }
    }
}
