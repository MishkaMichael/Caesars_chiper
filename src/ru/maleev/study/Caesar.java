package ru.maleev.study;

import java.util.Scanner;

public class Caesar {               // программа реализует шифр Цезаря - сдвиг всех алфавитных символов строки на определенное число символов вправо

    public static void main(String[] args) {
        int key = 34;
        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String encriptString = encript(s, key);
        System.out.println("Encript:" + encriptString);
        String decriptString = decript(s, key);
        System.out.println("Decript:" + decriptString);
        System.out.println('\u0950'); // Знак Ом
    }

    public static String encript(String s, int key) {  // метод шифрования
        char[] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch : charArray) {
            if (Alphabet.en.contains(ch)) {
                ch = (char) Alphabet.en.get((Alphabet.en.indexOf(ch) + key) % Alphabet.en.size());
            } else if (Alphabet.en_upper.contains(ch)) {
                ch = (char) Alphabet.en_upper.get((Alphabet.en_upper.indexOf(ch) + key) % Alphabet.en_upper.size());
            } else if (Alphabet.ru.contains(ch)) {
                ch = (char) Alphabet.ru.get((Alphabet.ru.indexOf(ch) + key) % Alphabet.ru.size());
            } else if (Alphabet.ru_upper.contains(ch)) {
                ch = (char) Alphabet.ru_upper.get((Alphabet.ru_upper.indexOf(ch) + key) % Alphabet.ru_upper.size());
            }
            resultString.append(ch);
        }
        return String.valueOf(resultString);
    }


    public static String decript (String s, int key) {  // метод расшифровщика шифра
        char [] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch: charArray) {
            if (Alphabet.en.contains(ch)) {
                if ((Alphabet.en.indexOf(ch) - key % Alphabet.en.size()) < 0 ) {
                    ch = (char) Alphabet.en.get(Alphabet.en.size() - (key % Alphabet.en.size() - Alphabet.en.indexOf(ch)));
                } else ch = (char) Alphabet.en.get(Alphabet.en.indexOf(ch) - key % Alphabet.en.size());

            } else if (Alphabet.en_upper.contains(ch)) {
                if ((Alphabet.en_upper.indexOf(ch) - key % Alphabet.en_upper.size()) < 0 ) {
                    ch = (char) Alphabet.en_upper.get(Alphabet.en_upper.size() - (key % Alphabet.en_upper.size() - Alphabet.en_upper.indexOf(ch)));
                } else ch = (char) Alphabet.en_upper.get(Alphabet.en_upper.indexOf(ch) - key % Alphabet.en_upper.size());

            } else if (Alphabet.ru.contains(ch)) {
                if ((Alphabet.ru.indexOf(ch) - key % Alphabet.ru.size()) < 0 ) {
                    ch = (char) Alphabet.ru.get(Alphabet.ru.size() - (key % Alphabet.ru.size() - Alphabet.ru.indexOf(ch)));
                } else ch = (char) Alphabet.ru.get(Alphabet.ru.indexOf(ch) - key % Alphabet.ru.size());

            } else if (Alphabet.ru_upper.contains(ch)) {
                if ((Alphabet.ru_upper.indexOf(ch) - key % Alphabet.ru_upper.size()) < 0 ) {
                    ch = (char) Alphabet.ru_upper.get(Alphabet.ru_upper.size() - (key % Alphabet.ru_upper.size() - Alphabet.ru_upper.indexOf(ch)));
                } else ch = (char) Alphabet.ru_upper.get(Alphabet.ru_upper.indexOf(ch) - key % Alphabet.ru_upper.size());
            }
            resultString.append(ch);
        }
        return String.valueOf(resultString);
    }
}
