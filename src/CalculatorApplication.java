import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApplication extends JFrame {
    private JTextField firstNumberTextField;
    private JTextField secondNumberTextField;
    private JTextField resultTextField;

    public CalculatorApplication() {
        setTitle("Calculator");
        setSize(500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setLayout(new GridLayout(3, 2));

        JLabel firstNumberLabel = new JLabel("First Number:");
        firstNumberTextField = new JTextField();
        JLabel secondNumberLabel = new JLabel("Second Number:");
        secondNumberTextField = new JTextField();
        JLabel resultLabel = new JLabel("Result:");
        resultTextField = new JTextField();
        resultTextField.setEditable(false);

        inputPanel.add(firstNumberLabel);
        inputPanel.add(firstNumberTextField);
        inputPanel.add(secondNumberLabel);
        inputPanel.add(secondNumberTextField);
        inputPanel.add(resultLabel);
        inputPanel.add(resultTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new GridLayout(5, 1));

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('+');
            }
        });

        JButton subtractButton = new JButton("-");
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('-');
            }
        });

        JButton multiplyButton = new JButton("*");
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('*');
            }
        });

        JButton divideButton = new JButton("/");
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('/');
            }
        });

        JButton moduloButton = new JButton("%");
        moduloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult('%');
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(moduloButton);
        buttonPanel.add(clearButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    private void calculateResult(char operator) {
        double firstNumber = Double.parseDouble(firstNumberTextField.getText());
        double secondNumber = Double.parseDouble(secondNumberTextField.getText());

        double result = 0;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
        }

        resultTextField.setText(String.valueOf(result));
    }

    private void clearFields() {
        firstNumberTextField.setText("");
        secondNumberTextField.setText("");
        resultTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApplication();
            }
        });
    }
}