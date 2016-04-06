package com.goit.gojavaonline.module10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

    public File fileWriter(String s){

        String result = new Scrambler().scrambler(s);
        File file = new File("test.txt");

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
            }
            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

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

