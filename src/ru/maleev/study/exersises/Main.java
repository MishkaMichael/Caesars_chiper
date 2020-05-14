package ru.maleev.study.exersises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int key = 15; //ввести проверку целого и неотрицательного key

    public static void main(String[] args) {

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
        System.out.println('\u0950');
    }

    public static String encript (String s, List en, List EN, List ru, List RU) {
        char [] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char currentChar: charArray) {
            if (en.contains(currentChar)) {
                currentChar = (char) en.get((en.indexOf(currentChar) + key) % en.size());
            } else if (EN.contains(currentChar)) {
                currentChar = (char) EN.get((EN.indexOf(currentChar) + key) % EN.size());
            } else if (ru.contains(currentChar)) {
                currentChar = (char) ru.get((ru.indexOf(currentChar) + key) % ru.size());
            } else if (RU.contains(currentChar)) {
                currentChar = (char) RU.get((RU.indexOf(currentChar) + key) % RU.size());
            }
            resultString.append(currentChar);
        }
        return String.valueOf(resultString);
    }

    public static String decript (String s, List en, List EN, List ru, List RU) {
        char [] charArray = s.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char currentChar: charArray) {
            if (en.contains(currentChar)) {
                if ((en.indexOf(currentChar) - key) < 0 ) {
                    currentChar = (char) en.get(en.size() - (key - en.indexOf(currentChar)) % en.size());
                } else currentChar = (char) en.get(en.indexOf(currentChar) - key);

            } else if (EN.contains(currentChar)) {
                if ((EN.indexOf(currentChar) - key) < 0 ) {
                    currentChar = (char) EN.get(EN.size() - (key - EN.indexOf(currentChar)) % EN.size());
                } else currentChar = (char) EN.get(EN.indexOf(currentChar) - key);

            } else if (ru.contains(currentChar)) {
                if ((ru.indexOf(currentChar) - key) < 0 ) {
                    currentChar = (char) ru.get(ru.size() - (key - ru.indexOf(currentChar)) % ru.size());
                } else currentChar = (char) ru.get(ru.indexOf(currentChar) - key);

            } else if (RU.contains(currentChar)) {
                if ((RU.indexOf(currentChar) - key) < 0 ) {
                    currentChar = (char) RU.get(RU.size() - (key - RU.indexOf(currentChar)) % RU.size());
                } else currentChar = (char) RU.get(RU.indexOf(currentChar) - key);
            }
            resultString.append(currentChar);
        }
        return String.valueOf(resultString);
    }
}
