package com.goit.gojavaonline.module10;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

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

 public String fileReader(File file) throws FileNotFoundException {
     String result ="";
     StringBuilder reader = new StringBuilder();
     Scanner in = new Scanner(file);
     while(in.hasNext())
         reader.append(in.nextLine());
     in.close();
     String s = reader.toString();
     char[] mas = s.toCharArray(); // преобразовываем строку в символы
     int[] charCodes = new int[mas.length];
     for (int i = 0; i < mas.length; i++) {
         charCodes[i] = Integer.valueOf(mas[i]); //преобразовали в ASCII код
     }

     int[] decoderMassive = new int[charCodes.length];
     for (int i = 0; i < charCodes.length; i++) {
         decoderMassive[i] = (charCodes[i] - getKey() + getValue()) % getValue(); // decoder
     }

     char[] charDecoderMassive = new char[decoderMassive.length];
     for (int i = 0; i < decoderMassive.length; i++) {
         charDecoderMassive[i] = (char) (decoderMassive[i]);//перевели в массив символов
     }

     for (int i = 0; i < decoderMassive.length; i++) {
         result += String.valueOf(charDecoderMassive[i]);
     }
     return result;
 }
}

