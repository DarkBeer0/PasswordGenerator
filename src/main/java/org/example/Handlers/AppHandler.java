package org.example.Handlers;

import org.example.Listeners.ButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class AppHandler extends JFrame {

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
        JTextField textField = new JTextField("pass name (optional)");
    }

    void addCheckBox() {
        JCheckBox checkBox = new JCheckBox("Save to file");
    }

    void addSlider() {

    }

    void addOutput() {

    }
}
