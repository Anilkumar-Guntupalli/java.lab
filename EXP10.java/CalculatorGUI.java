package exp10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    // Declare components
    private JTextField num1Field, num2Field;
    private JButton addBtn, subBtn, mulBtn, divBtn;

    public CalculatorGUI() {
        // Frame title
        setTitle("Swing Application");
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and text fields
        JLabel label1 = new JLabel("Number 1");
        JLabel label2 = new JLabel("Number 2");
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);

        // Buttons
        addBtn = new JButton("ADD");
        subBtn = new JButton("SUBTRACT");
        mulBtn = new JButton("MULTIPLY");
        divBtn = new JButton("DIVIDE");

        // Add action listeners
        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        // Add components to frame
        add(label1);
        add(num1Field);
        add(label2);
        add(num2Field);
        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        // Frame settings
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            String operation = "";

            if (e.getSource() == addBtn) {
                result = num1 + num2;
                operation = "Addition";
            } else if (e.getSource() == subBtn) {
                result = num1 - num2;
                operation = "Subtraction";
            } else if (e.getSource() == mulBtn) {
                result = num1 * num2;
                operation = "Multiplication";
            } else if (e.getSource() == divBtn) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
                operation = "Division";
            }

            // Display result in message box
            JOptionPane.showMessageDialog(this, operation + ": " + result, "Message", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
