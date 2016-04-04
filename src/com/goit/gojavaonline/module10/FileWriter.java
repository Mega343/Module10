package com.goit.gojavaonline.module10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {


    private int key = 250;
    private int value = 256;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public File fileWriter(String s){

        File file = new File("test.txt");

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }
            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            String result = "";
            char[] mas = s.toCharArray(); // преобразовываем строку в символы
            int[] charCodes = new int[mas.length];
            for (int i = 0; i < mas.length; i++) {
                charCodes[i] = Integer.valueOf(mas[i]); //преобразовали в ASCII код
            }

            int[] encryptedMassive = new int[charCodes.length];
            for (int i = 0; i < charCodes.length; i++) {
                encryptedMassive[i] = (charCodes[i] + getKey())%getValue();// шифруем
            }

            char[] charEncryptedMassive = new char[encryptedMassive.length];
            for (int i = 0; i < encryptedMassive.length; i++) {
                charEncryptedMassive[i] =  (char)(encryptedMassive[i]); //перевели в массив символов
            }

            for (int i = 0; i < charEncryptedMassive.length; i++) {
                result += String.valueOf(charEncryptedMassive[i]); // преобразовали к строке
            }

            try {
                //Записываем текст у файл
                out.print(result);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}

