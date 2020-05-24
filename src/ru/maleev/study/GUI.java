package ru.maleev.study;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
    // this is FIELD)))
    static final JFrame FRAME = new JFrame("Caesar cipher");
    //если field static то он пишется с большых буквы всегда.
    // между словами "_", например THIS_IS_TEST_FIELD_STATIC
    static public void run() {
        //Создадим окно, настраиваем иконку, закрытие по крестику

        ImageIcon img = new ImageIcon("java.png");
        FRAME.setIconImage(img.getImage());
        FRAME.setDefaultCloseOperation(FRAME.EXIT_ON_CLOSE);

        //Создадим панели
        JPanel bottomPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        //Подписи
        JLabel labelInput = new JLabel("Исходная строка");
        JLabel labelOutput = new JLabel("Результат");
        JLabel labelKey = new JLabel("Ключ шифрования");

        //Текстовые поля
        JTextArea textInput = new JTextArea(1,20);
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);
        JTextArea textOutput = new JTextArea(1,20);
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        JTextField textKey = new JTextField(5);

        //Создадим кнопки
        JButton encript = new JButton("Зашифровать");
        JButton decript = new JButton("Расшифровать");
        JButton copyButton = new JButton("Скопировать в исходную");


        //Событие для кнопки "Зашифровать"
        encript.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String string = textInput.getText();
                // Считываем ключ и проверяем значение
                String keyString = textKey.getText();
                char [] keyArr = keyString.toCharArray();
                for (char ch: keyArr) {
                    if (!Character.isDigit(ch)) {
                        textOutput.setText("Введите корректный ключ шифрования");
                        textKey.setText(null);
                    }
                    // Если ключ верный, зашифровываем сообщение
                    else {
                        int key = Integer.parseInt(keyString);
                        Caesar newCaesar = new Caesar();
                        String encriptedString = newCaesar.encrypt(string, key);
                        textOutput.setText(encriptedString);
                    }
                }
            }
        });

        //Событие для кнопки "Расшифровать"
        decript.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Действие
                String string = textInput.getText();
                // Считываем ключ и проверяем значение
                String keyString = textKey.getText();
                char [] keyArr = keyString.toCharArray();
                for (char ch: keyArr) {
                    if (!Character.isDigit(ch)) {
                        textOutput.setText("Введите корректный ключ шифрования");
                        textKey.setText(null);
                    }
                    // Если ключ верный, зашифровываем сообщение
                    else {
                        int key = Integer.parseInt(keyString);
                        Caesar newCaesar = new Caesar();
                        String decriptedString = newCaesar.decrypt(string, key);
                        textOutput.setText(decriptedString);
                    }
                }
            }
        });


        //Событие для кнопки "Скопировать"
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Действие
                textInput.setText(textOutput.getText());
            }
        });


        //Добавим кнопки и поля на панель

        topPanel.add(labelInput);
        topPanel.add(textInput);
        topPanel.add(labelKey);
        topPanel.add(textKey);
        centerPanel.add(encript);
        centerPanel.add(decript);
        bottomPanel.add(labelOutput);
        bottomPanel.add(textOutput);
        bottomPanel.add(copyButton);


        //Добавим панели в окно и настроим
        FRAME.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        FRAME.getContentPane().add(BorderLayout.NORTH, topPanel);
        FRAME.getContentPane().add(BorderLayout.CENTER, centerPanel);

        FRAME.pack();
        FRAME.setSize(700, 200);
        FRAME.setLocationRelativeTo(null);
        FRAME.setVisible(true);
        FRAME.setResizable(true);
    }

    public static void main(String[] args) {
        run();
    }
}