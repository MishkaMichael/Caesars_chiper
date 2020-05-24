package ru.maleev.study;

import java.util.List;
import java.util.Scanner;

public class Caesar {               // программа реализует шифр Цезаря - сдвиг всех алфавитных символов строки на определенное число символов вправо

    public static void main(String[] args) {
        int key = 34;
        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String encriptString = encrypt(s, key);
        System.out.println("Encrypt:" + encriptString);
        String decriptString = decrypt(s, key);
        System.out.println("Decrypt:" + decriptString);
        System.out.println('\u0950'); // Знак Ом
    }

    public static String encrypt(String s, int key) {  // метод шифрования
        char[] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch : charArray) {
            ch = encryptChar(key, ch);
            resultString.append(ch);
        }
        return String.valueOf(resultString);
    }

    private static char encryptChar(int key, char ch) {
        List<Character> alphabet = returnAlphabetByChar(ch);
        if (alphabet != null) return encryption(alphabet, ch, key);
        else return ch;
    }

    private static List<Character> returnAlphabetByChar(char ch) {
        for (List<Character> alphabet: Alphabet.all) {
            if (alphabet.contains(ch)) return alphabet;
        }
        return null;
    }

    public static String decrypt(String s, int key) {  // метод расшифровщика шифра
        char[] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch : charArray) {
            if (Alphabet.en_lower.contains(ch)) { ch = decryption(Alphabet.en_lower, ch, key);}
            else if (Alphabet.en_upper.contains(ch)) { ch = decryption(Alphabet.en_upper, ch, key);}
            else if (Alphabet.ru_lower.contains(ch)) { ch = decryption(Alphabet.ru_lower, ch, key);}
            else if (Alphabet.ru_upper.contains(ch)) { ch = decryption(Alphabet.ru_upper, ch, key);}
            resultString.append(ch);
        }
        return String.valueOf(resultString);
    }

    public static char encryption(List alphabet, char ch, int key) {
            ch = (char) alphabet.get((alphabet.indexOf(ch) + key) % alphabet.size());
            return ch;
    }

    public static char decryption(List alphabet, char ch, int key) {
        if ((alphabet.indexOf(ch) - key % alphabet.size()) < 0) {
            ch = (char) alphabet.get(alphabet.size() - (key % alphabet.size() - alphabet.indexOf(ch)));
        } else ch = (char) alphabet.get(alphabet.indexOf(ch) - key % alphabet.size());
        return ch;
    }
}
