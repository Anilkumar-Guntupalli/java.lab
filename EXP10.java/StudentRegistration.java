package exp10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration {
    public static void main(String[] args) {
        new RegisterFrame();
    }
}

class RegisterFrame extends JFrame implements ActionListener {
    JTextField nameField;
    JRadioButton male, female;
    JCheckBox apple, samsung, redmi, oneplus;
    JComboBox<String> colorBox;
    JButton saveBtn;

    RegisterFrame() {
        setTitle("Student Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Name Field
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        // Gender
        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);

        // Model (Checkboxes)
        add(new JLabel("Model:"));
        JPanel modelPanel = new JPanel();
        apple = new JCheckBox("Apple");
        samsung = new JCheckBox("Samsung");
        redmi = new JCheckBox("Redmi");
        oneplus = new JCheckBox("OnePlus");
        modelPanel.add(apple);
        modelPanel.add(samsung);
        modelPanel.add(redmi);
        modelPanel.add(oneplus);
        add(modelPanel);

        // Color (ComboBox)
        add(new JLabel("Color:"));
        String[] colors = {"Black", "White", "Blue", "Red"};
        colorBox = new JComboBox<>(colors);
        add(colorBox);

        // Save Button
        add(new JLabel()); // blank cell for layout
        saveBtn = new JButton("Save");
        add(saveBtn);

        saveBtn.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not Selected");

        StringBuilder models = new StringBuilder();
        if (apple.isSelected()) models.append("Apple ");
        if (samsung.isSelected()) models.append("Samsung ");
        if (redmi.isSelected()) models.append("Redmi ");
        if (oneplus.isSelected()) models.append("OnePlus ");

        String color = (String) colorBox.getSelectedItem();

        new DisplayFrame(name, gender, models.toString(), color);
    }
}

class DisplayFrame extends JFrame {
    DisplayFrame(String name, String gender, String models, String color) {
        setTitle("Display Details");
        setSize(350, 200);
        setLayout(new BorderLayout());

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setText("Name: " + name + "\n"
                + "Gender: " + gender + "\n"
                + "Model: " + models + "\n"
                + "Color: " + color);

        add(displayArea, BorderLayout.CENTER);

        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(e -> dispose());
        add(okBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
