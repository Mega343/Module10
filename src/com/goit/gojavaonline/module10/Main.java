package com.goit.gojavaonline.module10;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileWriter writer = new FileWriter();
        FileReader reader = new FileReader();
        File file = writer.fileWriter("Go Java online");
        System.out.println(reader.fileReader(file));
    }
}
