import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.lang.Integer.parseInt;

/**
 * La classe Convertisseur est la classe principale du programme. Elle contient
 * la méthode main qui permet d'exécuter le logiciel de conversion de nombres en
 * français.
 *
 * @author JeongHan-Bae
 * @version 1.0
 */

public class Convertisseur {
    public static void main(String[] args) {
        Font timesNewRoman = new Font("Times New Roman", Font.PLAIN, 15); // Définir la police Times New Roman
        Font cambriaMathFont = new Font("Cambria Math", Font.PLAIN, 15); // Définir la police "Cambria Math"
        Font candara = new Font("Candara", Font.BOLD, 15); // Définir la police Candara

        JFrame frame = new JFrame("Convertisseur de Chiffres");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 320);
        frame.setLocationRelativeTo(null);

        frame.getRootPane().setBorder(new EmptyBorder(2,3,4,3));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 2.0;

        JLabel instructions = new JLabel("Veuillez entrer un nombre en Romain ou en Arabe :");
        instructions.setFont(timesNewRoman);
        instructions.setPreferredSize(new Dimension(360, 30));
        instructions.setBorder(new EmptyBorder(2, 2, 2, 2));
        c.gridy = 0;
        panel.add(instructions, c);

        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(360, 30));
        inputField.setBorder(new EmptyBorder(2, 2, 2, 2));
        c.gridy = 1;
        panel.add(inputField, c);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(4, 2, 0, 2));

        JButton convertButton = new JButton("Convertir");
        convertButton.setFont(candara);
        convertButton.setPreferredSize(new Dimension(160, 30));

        JButton clearButton = new JButton("Effacer");
        clearButton.setFont(candara);
        clearButton.setPreferredSize(new Dimension(160, 30));

        buttonPanel.add(convertButton);
        buttonPanel.add(clearButton);
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, c);

        frame.add(panel, BorderLayout.NORTH);

        JTextPane outputArea = new JTextPane();
        outputArea.setEditable(false);
        outputArea.setPreferredSize(new Dimension(360, 30));
        outputArea.setBorder(new EmptyBorder(2,2,2,2));

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel copyrightLabel = new JLabel("Copyright © 2023 JeongHan-Bae");
        copyrightLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Définir la police Arial
        southPanel.add(copyrightLabel, BorderLayout.EAST);

        panel.setBorder(new EmptyBorder(1, 2, 1, 2));

        frame.add(panel, BorderLayout.NORTH);
        frame.add(outputArea, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        String[] sOut = {"","",""};
        convertButton.addActionListener(e -> {
            String input = inputField.getText().trim();
            String inputWithoutSpaces = input.replaceAll(" ", "");
            String frenchOutput;

            if (isArabicNumeral(inputWithoutSpaces)) {
                try {int arabicNumeral = parseInt(inputWithoutSpaces);
                frenchOutput = Nums.intToFr(arabicNumeral);}
                catch (NumberFormatException ex) {
                    frenchOutput = "Entrée Plus GRANDE que INT.";
                }
            } else if (isRomanNumeral(inputWithoutSpaces)) {
                int arabicNumeral = Nums.romainToInt(inputWithoutSpaces);
                frenchOutput = Nums.intToFr(arabicNumeral);
            } else {
                frenchOutput = "Entrée INVALIDE.";
            }
            for (byte j = 2; j > 0; j--){
                sOut[j] = sOut[j - 1];
            }

            sOut[0] = ">> " + frenchOutput;
            outputArea.setText(sOut[0] + "\n" + sOut[1] + "\n" +sOut[2]);
            outputArea.setFont(cambriaMathFont);
        });

        clearButton.addActionListener(e -> {
            for (byte j = 0; j < 3; j++){
                sOut[j] = "";
            }
            outputArea.setText("");
        });

        frame.setVisible(true);
    }

    private static boolean isRomanNumeral(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true; // Empty
        }
        for (char c : input.toCharArray()) {
            if (!Nums.roToIntMap.containsKey(c)) {
                return false; // Invalid
            }
        }
        return true; // All Valid
    }
    private static boolean isArabicNumeral(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        int startIndex = 0;
        if (input.charAt(0) == '-') {
            startIndex = 1;
        }
        for (int i = startIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
