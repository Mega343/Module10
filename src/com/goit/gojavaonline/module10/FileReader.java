package com.goit.gojavaonline.module10;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {



 public String fileReader(File file) throws FileNotFoundException {

     StringBuilder reader = new StringBuilder();
     Scanner in = new Scanner(file);
     while (in.hasNext())
         reader.append(in.nextLine());
     in.close();
     String s = reader.toString();
     String result = new Decoder().decoder(s);
     return result;
 }
}

