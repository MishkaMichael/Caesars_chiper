package ru.maleev.study;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
    public static void run() {
        //Создадим окно, настраиваем иконку, закрытие по крестику
        final JFrame frame = new JFrame("Caesar cipher");
        ImageIcon img = new ImageIcon("java.png");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создадим панели
        JPanel bottomPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        //Подписи
        JLabel labelInput = new JLabel("Исходная строка");
        JLabel labelOutput = new JLabel("Результат");
        JLabel labelKey = new JLabel("Ключ шифрования");

        //Текстовые поля
        JTextField textInput = new JTextField(24);
        JTextField textOutput = new JTextField(24);
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
                        String encriptedString = newCaesar.encript(string, key);
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
                        String decriptedString = newCaesar.decript(string, key);
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
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        frame.getContentPane().add(BorderLayout.NORTH, topPanel);
        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);

        frame.pack();
        frame.setSize(700, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        run();
    }
}