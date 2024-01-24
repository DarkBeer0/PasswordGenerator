package org.example.Handlers;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class GeneratorHandler {
    public void CreatePassword(Boolean createFile, int numberOfChar, String name) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@$^&()-_=+";

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numberOfChar; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }
        AppHandler.output.setText(password.toString());
        AppHandler.output.setEnabled(true);
        if (createFile)
            CheckAndCreateFile(password.toString(), name);
        System.out.println("Password: " + password);
    }

    public boolean CheckAndCreateFile(String password, String colName) {
        Path potentialFilePass = Paths.get(System.getenv("USERPROFILE") + "\\Desktop");
        String fileName = "PassGen.txt";
        File file = new File(potentialFilePass + "\\" + fileName);
        //File file = new File("C:\\Test" + "\\" + fileName);
        try {
            if (colName.equals("pass name (optional)"))
                colName = "not specified";
            String content = colName + " - " + password;
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                content += " " + reader.readLine();
            } else
                file.createNewFile();
            FileWriter myWriter = new FileWriter(file.getPath());
            myWriter.write(content);
            myWriter.close();
            System.out.println("File created: " + file.getPath());
            return true;
        } catch (IOException e) {
            System.err.println("Error when creating a file: " + e.getMessage());
            return false;
        }
    }
}
