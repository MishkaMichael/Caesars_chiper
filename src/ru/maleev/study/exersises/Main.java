package ru.maleev.study.exersises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {               // программа реализует шифр Цезаря - сдвиг всех алфавитных символов строки на определенное число символов вправо

    public static int key = 15;   //ввести проверку целого и неотрицательного key
    public static void main(String[] args) {

        // Формирование алфавитов
        char [] arr_abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        List<Character> alphabet_en = new ArrayList<Character>();
        for (char ch: arr_abc) alphabet_en.add(ch);

        char [] arr_ABC = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        List<Character> alphabet_EN = new ArrayList<Character>();
        for (char ch: arr_ABC) alphabet_EN.add(ch);

        char [] arr_ru = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я'};
        List<Character> alphabet_ru = new ArrayList<Character>();
        for (char ch: arr_ru) alphabet_ru.add(ch);

        char [] arr_RU = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я'};
        List<Character> alphabet_RU = new ArrayList<Character>();
        for (char ch: arr_RU) alphabet_RU.add(ch);


        System.out.println("Введите текст");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String encriptString = encript(s, alphabet_en, alphabet_EN, alphabet_ru, alphabet_RU);
        System.out.println(encriptString);
//        String decriptString = decript(s, alphabet_en, alphabet_EN, alphabet_ru, alphabet_RU);
//        System.out.println(decriptString);
        System.out.println('\u0950'); // Знак Ом
    }

    public static String encript (String s, List en, List EN, List ru, List RU) {  // метод шифрования
        char [] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch: charArray) {
            if (en.contains(ch)) {
                ch = (char) en.get((en.indexOf(ch) + key) % en.size());
            } else if (EN.contains(ch)) {
                ch = (char) EN.get((EN.indexOf(ch) + key) % EN.size());
            } else if (ru.contains(ch)) {
                ch = (char) ru.get((ru.indexOf(ch) + key) % ru.size());
            } else if (RU.contains(ch)) {
                ch = (char) RU.get((RU.indexOf(ch) + key) % RU.size());
            }
            resultString.append(ch);
        }
        return String.valueOf(resultString);
    }

    public static String decript (String s, List en, List EN, List ru, List RU) {  // метод расшифровщика шифра
        char [] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char ch: charArray) {
            if (en.contains(ch)) {
                if ((en.indexOf(ch) - key) < 0 ) {
                    ch = (char) en.get(en.size() - (key - en.indexOf(ch)) % en.size());
                } else ch = (char) en.get(en.indexOf(ch) - key);

            } else if (EN.contains(ch)) {
                if ((EN.indexOf(ch) - key) < 0 ) {
                    ch = (char) EN.get(EN.size() - (key - EN.indexOf(ch)) % EN.size());
                } else ch = (char) EN.get(EN.indexOf(ch) - key);

            } else if (ru.contains(ch)) {
                if ((ru.indexOf(ch) - key) < 0 ) {
                    ch = (char) ru.get(ru.size() - (key - ru.indexOf(ch)) % ru.size());
                } else ch = (char) ru.get(ru.indexOf(ch) - key);

            } else if (RU.contains(ch)) {
                if ((RU.indexOf(ch) - key) < 0 ) {
                    ch = (char) RU.get(RU.size() - (key - RU.indexOf(ch)) % RU.size());
                } else ch = (char) RU.get(RU.indexOf(ch) - key);
            }
            resultString.append(ch);
        }
        return String.valueOf(resultString);
    }
}
