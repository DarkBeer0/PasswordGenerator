package org.example.Handlers;

import org.example.Listeners.ButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class AppHandler extends JFrame {
    public static JSlider slider = null;
    public static JTextField input = null;
    public static JTextField output = null;
    public static JCheckBox checkBox = null;

    public void StartApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pass-Gen");
        JLabel text = new JLabel();
        text.setPreferredSize(new Dimension(250, 200));

        addButton();
        addInput();
        addCheckBox();
        addSlider();
        addOutput();

        this.getContentPane().add(text, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    void addButton() {
        JButton button = new JButton("Start");
        button.setBounds(150, 160, 90, 30);
        ButtonActionListener listener = new ButtonActionListener();
        button.addActionListener(listener);
        this.add(button);
    }

    void addInput() {
        input = new JTextField("pass name (optional)");
        input.setBounds(5, 10, 135, 25);
        this.add(input);
    }

    void addCheckBox() {
        checkBox = new JCheckBox("Save to file");
        checkBox.setBounds(2, 40, 100, 25);
        this.add(checkBox);
    }

    void addSlider() {
        JLabel label = new JLabel("Numbers of characters: ");
        label.setBounds(5, 60, 150, 30);
        this.add(label);

        slider = new JSlider(8, 32, 16);
        slider.setBounds(0, 90, 250, 45);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setForeground(Color.black);
        slider.setSnapToTicks(true);
        this.add(slider);
    }

    void addOutput() {
        output = new JTextField("your future password");
        output.setBounds(5, 163, 135, 25);
        output.setEnabled(false);
        this.add(output);
    }
}
