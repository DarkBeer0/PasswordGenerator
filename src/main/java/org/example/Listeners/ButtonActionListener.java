package org.example.Listeners;

import org.example.Handlers.AppHandler;
import org.example.Handlers.GeneratorHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {
    public void actionPerformed(ActionEvent evt) {
        //System.out.println("Debug msg #1");
        GeneratorHandler generatorHandler = new GeneratorHandler();
        generatorHandler.CreatePassword(AppHandler.checkBox.isSelected(), AppHandler.slider.getValue(), AppHandler.input.getText());
    }
}
